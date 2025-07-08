const express = require('express');
const router = express.Router();
const { getDB } = require('./db');

// Obtener todos los muebles (opcional)
router.get('/forniture', async (req, res) => {
  try {
    const db = getDB();
    const forniture = await db.collection('forniture').find().toArray();
    res.json(forniture);
  } catch (error) {
    console.error("Error fetching forniture:", error);
    res.status(500).json({ error: 'Error fetching forniture' });
  }
});

// Buscar un mueble por su _id personalizado (string)
router.get('/forniture/:id', async (req, res) => {
  try {
    const db = getDB();
    const id = req.params.id;
    const item = await db.collection('forniture').findOne({ _id: id });
    if (!item) {
      return res.status(404).json({ error: 'Forniture not found' });
    }
    res.json(item);
  } catch (error) {
    console.error("Error fetching forniture by _id:", error);
    res.status(500).json({ error: 'Error fetching forniture by id' });
  }
});

module.exports = router;
