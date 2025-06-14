import express from 'express';
import {MongoClient} from 'mongodb';

const app = express();
const PORT = 8000;
const MONGO_URL = 'mongodb+srv://KevinV593:KevinV593@cluster0.7ufczsp.mongodb.net/WarGame?retryWrites=true&w=majority&appName=Cluster0';

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