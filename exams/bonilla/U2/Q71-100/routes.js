const express = require('express');
const router = express.Router();
const { getDB } = require('./db');
const { ObjectId } = require('mongodb');


// Read by Id
router.get('forniture', async (req, res) => {
    try {
        const db = getDB();
        const cellphones = await db.collection('forniture').find().toArray();
        res.json(cellphones);
    } catch (error) {
        res.status(500).json({ error: 'Error fetching forniture' });
    }
});

module.exports = router;
