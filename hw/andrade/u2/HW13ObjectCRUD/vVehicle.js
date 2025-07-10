const readline = require('readline-sync');
const { MongoClient } = require('mongodb');

const uri = 'mongodb://localhost:27017';
const client = new MongoClient(uri);
const dbName = 'vehicleDB';
const collectionName = 'vehicles';

async function agregarVehiculo(db) {
    const vehicle = {
        serial: readline.question('Número de serie: '),
        brand: readline.question('Marca: '),
        model: readline.question('Modelo: '),
        year: parseInt(readline.question('Año: ')),
        price: parseFloat(readline.question('Precio en USD: '))
    };
    await db.collection(collectionName).insertOne(vehicle);
    console.log('✅ Vehículo agregado.\n');
}

async function buscarVehiculo(db) {
    const serial = readline.question('Número de serie a buscar: ');
    const vehicle = await db.collection(collectionName).findOne({ serial });
    console.log(vehicle ? vehicle : '❌ Vehículo no encontrado.');
}

async function actualizarVehiculo(db) {
    const serial = readline.question('Número de serie del vehículo a actualizar: ');
    const updates = {
        brand: readline.question('Nueva marca: '),
        model: readline.question('Nuevo modelo: '),
        year: parseInt(readline.question('Nuevo año: ')),
        price: parseFloat(readline.question('Nuevo precio: '))
    };
    const result = await db.collection(collectionName).updateOne({ serial }, { $set: updates });
    console.log(result.modifiedCount ? '✅ Vehículo actualizado.' : '❌ Vehículo no encontrado.');
}

async function eliminarVehiculo(db) {
    const serial = readline.question('Número de serie del vehículo a eliminar: ');
    const result = await db.collection(collectionName).deleteOne({ serial });
    console.log(result.deletedCount ? '✅ Vehículo eliminado.' : '❌ Vehículo no encontrado.');
}

async function listarVehiculos(db) {
    const vehicles = await db.collection(collectionName).find().toArray();
    console.log('\n🚗 Vehículos:');
    console.log(JSON.stringify(vehicles, null, 2));
}

async function mostrarPrecioConvertido(db) {
    const tasa = parseFloat(readline.question('Tasa de conversión (por ejemplo, 0.92 para euros): '));
    const vehicles = await db.collection(collectionName).find().toArray();
    console.log('\n🚗 Precios convertidos:');
    vehicles.forEach(v => {
        console.log(`Serial: ${v.serial}, Precio original: $${v.price}, Convertido: ${v.price * tasa}`);
    });
}

async function main() {
    await client.connect();
    const db = client.db(dbName);

    let salir = false;
    while (!salir) {
        console.log('\n1. Añadir vehículo');
        console.log('2. Buscar vehículo por serial');
        console.log('3. Actualizar vehículo por serial');
        console.log('4. Eliminar vehículo por serial');
        console.log('5. Mostrar todos los vehículos');
        console.log('6. Mostrar precio en otra moneda');
        console.log('0. Salir');
        const opcion = readline.question('Elige una opción: ');

        switch (opcion) {
            case '1':
                await agregarVehiculo(db);
                break;
            case '2':
                await buscarVehiculo(db);
                break;
            case '3':
                await actualizarVehiculo(db);
                break;
            case '4':
                await eliminarVehiculo(db);
                break;
            case '5':
                await listarVehiculos(db);
                break;
            case '6':
                await mostrarPrecioConvertido(db);
                break;
            case '0':
                salir = true;
                console.log('👋 Saliendo...');
                break;
            default:
                console.log('❌ Opción inválida.');
        }
    }

    await client.close();
}

main().catch(console.error);