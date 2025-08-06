import express from 'express';
import cors from 'cors';
import { MongoClient } from 'mongodb';

const app = express();
app.use(cors());
app.use(express.json());

const uri = 'mongodb+srv://machicaiza22:pan@cluster0.dqlf2xq.mongodb.net/';
const client = new MongoClient(uri);
const dbName = 'MiBase';
const collectionName = 'dats';


app.get('/gifts', async (req, res) => {
  try {
    await client.connect();
    const db = client.db(dbName);
    const collection = db.collection(collectionName);
    const gifts = await collection.find().toArray();
    res.json(gifts);
  } catch (error) {
    console.error(error);
    res.status(500).json({ error: 'Error al obtener datos' });
  }
});


app.post('/gifts', async (req, res) => {
  try {
    await client.connect();
    const db = client.db(dbName);
    const collection = db.collection(collectionName);

    const newGift = req.body;
    const result = await collection.insertOne(newGift);

    res.status(201).json(result);
  } catch (error) {
    console.error(error);
    res.status(500).json({ error: 'Error al crear gift' });
  }
});


app.put('/gifts/:id', async (req, res) => {
  try {
    await client.connect();
    const db = client.db(dbName);
    const collection = db.collection(collectionName);

    const id = parseInt(req.params.id);
    const updatedGift = req.body;

    const result = await collection.updateOne({ id: id }, { $set: updatedGift });

    if (result.matchedCount === 0) return res.status(404).json({ error: 'Gift no encontrado' });

    res.json(result);
  } catch (error) {
    console.error(error);
    res.status(500).json({ error: 'Error al actualizar gift' });
  }
});


app.delete('/gifts/:id', async (req, res) => {
  try {
    await client.connect();
    const db = client.db(dbName);
    const collection = db.collection(collectionName);

    const id = parseInt(req.params.id);
    const result = await collection.deleteOne({ id: id });

    if (result.deletedCount === 0) return res.status(404).json({ error: 'Gift no encontrado' });

    res.json({ message: 'Gift eliminado' });
  } catch (error) {
    console.error(error);
    res.status(500).json({ error: 'Error al eliminar gift' });
  }
});

app.listen(3000, () => {
  console.log('Servidor en puerto 3000');
});
