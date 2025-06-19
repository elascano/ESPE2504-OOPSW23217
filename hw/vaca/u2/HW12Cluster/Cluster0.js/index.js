import express from 'express';
import {MongoClient} from 'mongodb';
import 'dotenv/config';

const app = express();
const PORT = process.env.PORT;
const MONGO_URL = process.env.MONGO_URL;

app.get('/getStudents', async (req, res) => {
    const client = new MongoClient(MONGO_URL);

  try {
    await client.connect();
    
    const database = client.db('WarGame');
    const collection = database.collection('Students');
    const students = await collection.find({}).toArray();

    console.log('Students Data:', JSON.stringify(students, null, 2));

    if (students.length > 0) {
      res.status(200).json(students);
    } else {
        res.status(404).json({message: 'No students found'});
    }

  } catch (error) {
     console.error('Error:', error);
     res.status(500).json({message: 'DataBase error'});
  } finally {
     await client.close();
  }
});

app.listen(PORT, () => {
    console.log(`Server is running on http://localhost:${PORT}/getStudents`);
});