import express from 'express';
import { MongoClient } from 'mongodb';
import path from 'path';
import { fileURLToPath } from 'url';
import { SortingContext } from './model/SortingContext.js';

const __filename = fileURLToPath(import.meta.url);
const __dirname = path.dirname(__filename);

const app = express();
const PORT = 3000;

app.use(express.json());
app.use(express.static(path.join(__dirname, 'public')));

// MongoDB Setup
const uri = 'mongodb+srv://KevinV593:KevinV593@cluster0.7ufczsp.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0';
const client = new MongoClient(uri);
const dbName = 'strategyCaizapanta';
const collectionName = 'arrayTammy';

await client.connect();
const db = client.db(dbName);
const collection = db.collection(collectionName);

// API Route
app.post('/api/sort', async (req, res) => {
  const inputArray = req.body.array;

  const context = new SortingContext();
  const algorithm = context.setSortStrategy(inputArray.length);
  const sortedArray = context.sort(inputArray);

  const record = {
    unsorted: inputArray.join(', '),
    size: inputArray.length,
    algorithm,
    sorted: sortedArray.join(', ')
  };

  await collection.insertOne(record);

  res.json(record);
});

app.listen(PORT, () => {
  console.log(`Server running at http://localhost:${PORT}`);
});
