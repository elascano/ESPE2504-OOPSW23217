const { MongoClient } = require('mongodb');

const uri = 'mongodb+srv://neolukk:neolukk@cluster0.gj7cw6m.mongodb.net/OOP?retryWrites=true&w=majority';

let client;
let db;

async function connectDB() {
  if (db) return db;
  client = new MongoClient(uri);
  await client.connect();
  db = client.db('OOP'); // Cambia al nombre real de tu BD
  return db;
}

module.exports = { connectDB };
