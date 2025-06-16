import express from 'express';
import { MongoClient, ObjectId } from 'mongodb';
import 'dotenv/config';

const app = express();
app.use(express.json());

const PORT = process.env.PORT || 8000; // Added default port
const MONGO_URL = process.env.MONGO_URL;

async function connectToDatabase() {
    const client = new MongoClient(MONGO_URL);
    await client.connect();
    return client;
}

function getCollection(client) {
    return client.db('OOP').collection('SoccerPlayers');
}

// Unified player lookup by _id
async function getPlayerById(client, id) {
    const collection = getCollection(client);
    try {
        return await collection.findOne({ _id: new ObjectId(id) });
    } catch (e) {
        console.error('Invalid ID format:', id);
        throw new Error("Invalid player ID format");
    }
}

// GET all players
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

// GET single player by _id
app.get('/players/:id', async (req, res) => {
    let client;
    console.log(`Fetching player with ID: ${req.params.id}`);
    
    try {
        client = await connectToDatabase();
        const player = await getPlayerById(client, req.params.id);
        
        if (player) {
            res.status(200).json(player);
        } else {
            res.status(404).json({ message: 'Player not found' });
        }
    } catch (error) {
        res.status(400).json({ 
            message: error.message,
            correctFormat: "24-character hex string",
            example: "684f6e6bee5313ff4fc0211f"
        });
    } finally {
        if (client) await client.close();
    }
});

// Start server
app.listen(PORT, () => {
    console.log(`Server running on http://localhost:${PORT}`);
});