const express = require('express');
const { MongoClient } = require('mongodb');
const cors = require('cors');
const path = require('path');

// Connection configuration
const connectionString = 'mongodb+srv://Micaela:Micaela@cluster0.7ny5ynf.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0';
const dbName = 'Microphone';
const collectionName = 'microphone';

const app = express();
const port = 3000;

// Improved CORS configuration
app.use(cors({
  origin: 'http://localhost:3000',
  methods: ['GET', 'POST', 'PUT', 'DELETE'],
  allowedHeaders: ['Content-Type']
}));

app.use(express.json());
app.use(express.static('public'));

// Serve HTML file
app.get('/', (req, res) => {
    res.sendFile(path.join(__dirname, 'public', 'index.html'));
});

// Add microphone endpoint
app.post('/add-microphone', async (req, res) => {
    console.log('Received data:', req.body); // Log incoming data
    
    const client = new MongoClient(connectionString, {
        connectTimeoutMS: 5000,
        serverSelectionTimeoutMS: 5000
    });
    
    try {
        await client.connect();
        console.log('Connected to MongoDB');
        
        const database = client.db(dbName);
        const collection = database.collection(collectionName);
        
        // Validate required fields
        if (!req.body.id || !req.body.price) {
            return res.status(400).json({ error: 'ID and Price are required fields' });
        }
        
        // Check if microphone exists
        const existingMic = await collection.findOne({ id: req.body.id });
        if (existingMic) {
            return res.status(400).json({ 
                error: 'Microphone with this ID already exists',
                existingData: existingMic
            });
        }
        
        // Insert new document
        const result = await collection.insertOne({
            ...req.body,
            createdAt: new Date()
        });
        
        res.status(201).json({
            success: true,
            message: 'Microphone added successfully',
            insertedId: result.insertedId,
            data: req.body
        });
        
    } catch (error) {
        console.error('Database error:', error);
        
        // Improved error handling
        let errorMessage = 'Internal server error';
        if (error instanceof MongoServerError) {
            errorMessage = 'Database operation failed';
        } else if (error.name === 'MongoNetworkError') {
            errorMessage = 'Could not connect to database';
        }
        
        res.status(500).json({ 
            success: false,
            error: errorMessage,
            details: error.message 
        });
    } finally {
        await client.close();
    }
});

// New endpoint to check server status
app.get('/health', (req, res) => {
    res.status(200).json({ 
        status: 'OK',
        timestamp: new Date().toISOString()
    });
});

// Start server
app.listen(port, () => {
    console.log(`Server running at http://localhost:${port}`);
}).on('error', (err) => {
    console.error('Server failed to start:', err);
});