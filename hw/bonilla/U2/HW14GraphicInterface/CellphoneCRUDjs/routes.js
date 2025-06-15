const express = require('express');
const router = express.Router();
const { getDB } = require('./db');
const { ObjectId } = require('mongodb');

// Crear un nuevo cellphone
router.post('/cellphones', async (req, res) => {
    try {
        const cellphone = req.body;
        const db = getDB();
        const result = await db.collection('cellphones').insertOne(cellphone);
        res.status(201).json({ message: 'Cellphone created', id: result.insertedId });
    } catch (error) {
        res.status(500).json({ error: 'Error creating cellphone' });
    }
});

// Leer todos los cellphones
router.get('/cellphones', async (req, res) => {
    try {
        const db = getDB();
        const cellphones = await db.collection('cellphones').find().toArray();
        res.json(cellphones);
    } catch (error) {
        res.status(500).json({ error: 'Error fetching cellphones' });
    }
});

// Actualizar un cellphone por ID
router.put('/cellphones/:id', async (req, res) => {
    try {
        const id = req.params.id;
        const cellphone = req.body;
        const db = getDB();
        const result = await db.collection('cellphones').updateOne(
            { _id: new ObjectId(id) },
            { $set: cellphone }
        );
        if (result.matchedCount === 0) {
            return res.status(404).json({ error: 'Cellphone not found' });
        }
        res.json({ message: 'Cellphone updated' });
    } catch (error) {
        res.status(500).json({ error: 'Error updating cellphone' });
    }
});

// Borrar un cellphone por ID
router.delete('/cellphones/:id', async (req, res) => {
    try {
        const id = req.params.id;
        const db = getDB();
        const result = await db.collection('cellphones').deleteOne({ _id: new ObjectId(id) });
        if (result.deletedCount === 0) {
            return res.status(404).json({ error: 'Cellphone not found' });
        }
        res.json({ message: 'Cellphone deleted' });
    } catch (error) {
        res.status(500).json({ error: 'Error deleting cellphone' });
    }
});

module.exports = router;
