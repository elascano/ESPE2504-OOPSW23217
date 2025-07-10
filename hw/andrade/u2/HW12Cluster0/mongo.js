const readline = require('readline-sync');
const { MongoClient, ObjectId } = require('mongodb');

const uri = 'mongodb://localhost:27017'; 
const client = new MongoClient(uri);
const dbName = 'discoDB';
const collectionName = 'discos';

async function agregarDisco(db) {
    const disco = {
        id: readline.question('ID: '),
        brand: readline.question('Marca: '),
        model: readline.question('Modelo: '),
        capacity: readline.question('Capacidad: '),
        type: readline.question('Tipo: '),
        price: parseFloat(readline.question('Precio: ')),
        releaseYear: parseInt(readline.question('Año de lanzamiento: ')),
        usedSpace: parseFloat(readline.question('Espacio usado: '))
    };
    await db.collection(collectionName).insertOne(disco);
    console.log('✅ Disco agregado correctamente.\n');
}

async function eliminarDisco(db) {
    const id = readline.question('Ingrese el ID del documento (_id de Mongo): ');
    try {
        const result = await db.collection(collectionName).deleteOne({ _id: new ObjectId(id) });
        if (result.deletedCount === 1) {
            console.log('✅ Disco eliminado.');
        } else {
            console.log('❌ No se encontró ningún disco con ese ID.');
        }
    } catch (err) {
        console.log('❌ ID inválido.');
    }
}

async function listarDiscos(db) {
    const discos = await db.collection(collectionName).find().toArray();
    console.log('\n📀 Lista de discos:');
    console.log(JSON.stringify(discos, null, 2));
    console.log('');
}

async function main() {
    try {
        await client.connect();
        const db = client.db(dbName);

        let salir = false;
        while (!salir) {
            console.log('\n1. Agregar disco');
            console.log('2. Eliminar disco por ID');
            console.log('3. Listar discos');
            console.log('4. Salir');
            const opcion = readline.question('Elige una opción: ');

            switch (opcion) {
                case '1':
                    await agregarDisco(db);
                    break;
                case '2':
                    await eliminarDisco(db);
                    break;
                case '3':
                    await listarDiscos(db);
                    break;
                case '4':
                    salir = true;
                    console.log('👋 Saliendo...');
                    break;
                default:
                    console.log('❌ Opción inválida');
            }
        }
    } finally {
        await client.close();
    }
}

main().catch(console.error);