const { MongoClient, ServerApiVersion } = require('mongodb');

const uri = "mongodb+srv://neolukk:neolukk@cluster0.gj7cw6m.mongodb.net/OOP?retryWrites=true&w=majority";

const client = new MongoClient(uri, {
    serverApi: {
        version: ServerApiVersion.v1,
        strict: true,
        deprecationErrors: true,
    }
});

let db;

async function connectDB() {
    try {
        await client.connect();
        db = client.db("OOP"); // nombre de tu base de datos
        console.log("Conectado a MongoDB Atlas");
    } catch (error) {
        console.error("Error conectando a MongoDB:", error);
    }
}

function getDB() {
    if (!db) {
        throw new Error("Conexión a la base de datos no establecida");
    }
    return db;
}

module.exports = { connectDB, getDB };
