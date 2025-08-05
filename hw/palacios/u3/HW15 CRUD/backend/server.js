const express = require("express");
const cors = require("cors");
const { MongoClient } = require("mongodb");
// require("dotenv").config(); ← esto lo comentamos

const app = express();
const PORT = 3000;

app.use(cors());
app.use(express.json());

const uri = "mongodb+srv://Micaela:Micaela@cluster0.7ny5ynf.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
const client = new MongoClient(uri);
let collection;

async function conectarDB() {
  try {
    await client.connect();
    const db = client.db("SoccerTeams");
    collection = db.collection("soccer_teams");
    console.log("Connected to MongoDB Atlas");
  } catch (error) {
    console.error("Error connecting to the database:", error);
  }
}
conectarDB();

app.post("/team", async (req, res) => {
  const equipo = req.body;
  await collection.insertOne(equipo);
  res.json({ mensaje: "Save team", porcentaje: equipo.porcentaje });
});

app.listen(PORT, () => {
  console.log(`Server running on http://localhost:${PORT}`);
});
