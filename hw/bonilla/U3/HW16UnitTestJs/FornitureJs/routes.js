const express = require('express');
const router = express.Router();
const { ObjectId } = require('mongodb');
const { connectDB } = require('./db');

const collectionName = 'forniture';

// Obtener todo (Read all)
router.get('/', async (req, res) => {
  try {
    const db = await connectDB();
    const items = await db.collection(collectionName).find({}).toArray();
    res.json(items);
  } catch (err) {
    res.status(500).json({ error: 'Error fetching data' });
  }
});

// Obtener uno por ID (Read one)
router.get('/:id', async (req, res) => {
  try {
    const db = await connectDB();
    const id = req.params.id;
    const item = await db.collection(collectionName).findOne({ _id: id });
    if (!item) return res.status(404).json({ error: 'Not found' });
    res.json(item);
  } catch (err) {
    res.status(500).json({ error: 'Error fetching data' });
  }
});

// Crear nuevo (Create)
router.post('/', async (req, res) => {
  try {
    const db = await connectDB();
    const newItem = req.body;
    if (!newItem._id || !newItem.name || !newItem.quality || !newItem.value) {
      return res.status(400).json({ error: 'Missing required fields' });
    }
    // Insertar
    await db.collection(collectionName).insertOne(newItem);
    res.status(201).json({ message: 'Created', item: newItem });
  } catch (err) {
    res.status(500).json({ error: 'Error creating item' });
  }
});

// Actualizar por ID (Update)
router.put('/:id', async (req, res) => {
  try {
    const db = await connectDB();
    const id = req.params.id;
    const updateData = req.body;
    const result = await db.collection(collectionName).updateOne(
      { _id: id },
      { $set: updateData }
    );
    if (result.matchedCount === 0) return res.status(404).json({ error: 'Not found' });
    res.json({ message: 'Updated' });
  } catch (err) {
    res.status(500).json({ error: 'Error updating item' });
  }
});

// Eliminar por ID (Delete)
router.delete('/:id', async (req, res) => {
  try {
    const db = await connectDB();
    const id = req.params.id;
    const result = await db.collection(collectionName).deleteOne({ _id: id });
    if (result.deletedCount === 0) return res.status(404).json({ error: 'Not found' });
    res.json({ message: 'Deleted' });
  } catch (err) {
    res.status(500).json({ error: 'Error deleting item' });
  }
});


module.exports = router;
