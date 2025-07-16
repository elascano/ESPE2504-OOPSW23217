import express from 'express';
import { MongoClient, ObjectId } from 'mongodb';
import 'dotenv/config';
import path from 'path';
import { fileURLToPath } from 'url';

// Configure __dirname for ES modules
const __filename = fileURLToPath(import.meta.url);
const __dirname = path.dirname(__filename);

const app = express();

// Middleware
app.use(express.json());
app.use(express.static(path.join(__dirname, 'public'))); // Serve from public folder

const PORT = process.env.PORT || 8000;
const MONGO_URL = process.env.MONGO_URL;

// Database connection
async function connectToDatabase() {
    const client = new MongoClient(MONGO_URL);
    await client.connect();
    return client;
}

function getCollection(client) {
    return client.db('OOP').collection('SoccerPlayers');
}

// Routes
app.get('/', (req, res) => {
    res.sendFile(path.join(__dirname, 'public', 'index.html'));
});

app.get('/players', async (req, res) => {
    let client;
    try {
        client = await connectToDatabase();
        const players = await getCollection(client).find({}).toArray();
        res.status(200).json(players);
    } catch (error) {
        res.status(500).json({ message: error.message });
    } finally {
        if (client) await client.close();
    }
});

app.get('/players/:id', async (req, res) => {
    let client;
    try {
        client = await connectToDatabase();
        const player = await getCollection(client).findOne({ 
            $or: [
                { _id: new ObjectId(req.params.id) },
                { id: parseInt(req.params.id) }
            ]
        });
        
        if (player) {
            res.status(200).json(player);
        } else {
            res.status(404).json({ message: 'Player not found' });
        }
    } catch (error) {
        res.status(400).json({ 
            message: error.message,
            correctFormat: "MongoDB ObjectId or numeric ID",
            example: "684f6e6bee5313ff4fc0211f or 1"
        });
    } finally {
        if (client) await client.close();
    }
});

app.delete('/players/:id', async (req, res) => {
    let client;
    try {
        client = await connectToDatabase();
        const collection = getCollection(client);
        
        const result = await collection.deleteOne({ 
            $or: [
                { _id: new ObjectId(req.params.id) },
                { id: parseInt(req.params.id) }
            ]
        });
        
        if (result.deletedCount === 1) {
            res.status(200).json({ message: 'Player deleted successfully' });
        } else {
            res.status(404).json({ message: 'Player not found' });
        }
    } catch (error) {
        res.status(400).json({ message: error.message });
    } finally {
        if (client) await client.close();
    }
});

// Start server
app.listen(PORT, () => {
    console.log(`Server running on http://localhost:${PORT}`);
});