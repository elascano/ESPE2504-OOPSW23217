import express from 'express';
import {MongoClient, ObjectId} from 'mongodb';
import 'dotenv/config';

const app = express();
app.use(express.json());

const PORT = process.env.PORT;
const MONGO_URL = process.env.MONGO_URL;

async function connectToDatabase() {
    const client = new MongoClient(MONGO_URL);
    await client.connect();
    return client;
}

function getCollection(client) {
    return client.db('OOP').collection('SoccerPlayers');
}

async function getAllPlayers(client) {
    const collection = getCollection(client);
    return await collection.find({}).toArray();
}

async function getPlayerByNumberId(client, id) {
    const collection = getCollection(client);
    return await collection.findOne({
      id: parseInt(id) 
    });
}

async function createPlayer(client, playerData) {
    const collection = getCollection(client);
    const result = await collection.insertOne(playerData);
    return { ...playerData, _id: result.insertedId };
}

async function updatePlayer(client, id, updates) {
    const collection = getCollection(client);
    const result = await collection.updateOne(
        { id: parseInt(id) },
        { $set: updates }
    );
    return result.modifiedCount;
}

async function deletePlayer(client, id) {
    const collection = getCollection(client);
    const result = await collection.deleteOne({ id: parseInt(id) });
    return result.deletedCount;
}

app.get('/getPlayers', async (req, res) => {
  let client;
    try {
        client = await connectToDatabase();
        const player = await getAllPlayers(client, req.params.id);
        
        if (player) {
            res.status(200).json(player);
        } else {
            res.status(404).json({ message: 'Player not found' });
        }
    } catch (error) {
        console.error('Error:', error);
        res.status(400).json({ 
            message: 'Invalid player ID',
            details: 'ID must be a number (1, 2, 3...)'
        });
    } finally {
        if (client) await client.close();
    }
});

// GET single player
app.get('/players/:id', async (req, res) => {
    let client;

    try {
        client = await connectToDatabase();
        const player = await getPlayerById(client, req.params.id);

       if (player) {
        res.status(200).json(player);
        } else {
            res.status(404).json({ message: 'Player not found' });
        }

    } catch (error) {
        console.error('Error:', error);
        res.status(400).json({ 
          message: 'Invalid player ID',
          details: 'ID must be a number (1, 2, 3...)'
        });
    } finally {
        if (client) await client.close();
    }
});

// POST create player
app.post('/players', async (req, res) => {
    let client;

    try {
        client = await connectToDatabase();
        const newPlayer = await createPlayer(client, req.body);
        res.status(201).json(newPlayer);
    } catch (error) {
        console.error('Error:', error);
        res.status(500).json({ message: 'Database error' });
    } finally {
        if (client) await client.close();
    }
});

// PUT update player
app.put('/players/:id', async (req, res) => {
    let client;
    try {
        client = await connectToDatabase();
        const modifiedCount = await updatePlayer(client, req.params.id, req.body);
        modifiedCount
            ? res.status(200).json({ message: 'Player updated' })
            : res.status(404).json({ message: 'Player not found' });
    } catch (error) {
        console.error('Error:', error);
        res.status(500).json({ message: 'Database error' });
    } finally {
        if (client) await client.close();
    }
});

// DELETE player
app.delete('/players/:id', async (req, res) => {
    let client;
    try {
        client = await connectToDatabase();
        const deletedCount = await deletePlayer(client, req.params.id);
        deletedCount
            ? res.status(200).json({ message: 'Player deleted' })
            : res.status(404).json({ message: 'Player not found' });
    } catch (error) {
        console.error('Error:', error);
        res.status(500).json({ message: 'Database error' });
    } finally {
        if (client) await client.close();
    }
});

app.listen(PORT, () => {
    console.log(`Server running on http://localhost:${PORT}`);
});