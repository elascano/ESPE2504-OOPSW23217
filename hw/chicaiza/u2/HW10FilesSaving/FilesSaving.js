const fs = require('fs');
const readline = require('readline');

// Clase CompactDisk con 8 atributos
class CompactDisk {
    constructor(id, brand, model, capacity, type, price, releaseYear, usedSpace) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.capacity = capacity;
        this.type = type;
        this.price = price;
        this.releaseYear = releaseYear;
        this.usedSpace = usedSpace;
    }
}

// Leer desde archivo JSON
function readCompactDisk() {
    if (!fs.existsSync('CompactDisks.json')) {
        return [];
    }
    const data = fs.readFileSync('CompactDisks.json', 'utf8');
    if (data.trim() === '') return [];
    return JSON.parse(data);
}

// Guardar en archivo JSON
function saveCompactDisk(compactDisks) {
    fs.writeFileSync('CompactDisks.json', JSON.stringify(compactDisks, null, 2));
}

// Utilidad para hacer preguntas por consola
function ask(rl, question) {
    return new Promise(resolve => rl.question(question, resolve));
}

// Crear nuevo CompactDisk
async function createCompactDisk(rl) {
    const questions = [
        "ID: ", "Brand: ", "Model: ", "Capacity (MB): ", "Type: ",
        "Price ($): ", "Release Year: ", "Used Space (MB): "
    ];

    const answers = [];
    for (const q of questions) {
        answers.push(await ask(rl, q));
    }

    const disk = new CompactDisk(
        answers[0],
        answers[1],
        answers[2],
        parseInt(answers[3]),
        answers[4],
        parseFloat(answers[5]),
        parseInt(answers[6]),
        parseInt(answers[7])
    );

    const disks = readCompactDisk();
    disks.push(disk);
    saveCompactDisk(disks);
    console.log("💾 Compact Disk guardado correctamente.");
}

// Listar todos los discos
function listCompactDisks() {
    const disks = readCompactDisk();
    if (disks.length === 0) {
        console.log("📁 No hay discos registrados.");
    } else {
        console.table(disks);
    }
}

// Actualizar disco por ID
async function updateCompactDisk(rl) {
    const id = await ask(rl, "Ingrese el ID del disco a actualizar: ");
    const disks = readCompactDisk();
    const index = disks.findIndex(d => d.id === id);

    if (index === -1) {
        console.log("❌ Disco no encontrado.");
        return;
    }

    console.log("Ingrese los nuevos valores:");
    const questions = [
        "Brand: ", "Model: ", "Capacity (MB): ", "Type: ",
        "Price ($): ", "Release Year: ", "Used Space (MB): "
    ];

    const answers = [];
    for (const q of questions) {
        answers.push(await ask(rl, q));
    }

    disks[index].brand = answers[0];
    disks[index].model = answers[1];
    disks[index].capacity = parseInt(answers[2]);
    disks[index].type = answers[3];
    disks[index].price = parseFloat(answers[4]);
    disks[index].releaseYear = parseInt(answers[5]);
    disks[index].usedSpace = parseInt(answers[6]);

    saveCompactDisk(disks);
    console.log("✅ Disco actualizado.");
}

// Eliminar disco por ID
async function deleteCompactDisk(rl) {
    const id = await ask(rl, "Ingrese el ID del disco a eliminar: ");
    const disks = readCompactDisk();
    const newDisks = disks.filter(d => d.id !== id);

    if (newDisks.length === disks.length) {
        console.log("❌ No se encontró un disco con ese ID.");
    } else {
        saveCompactDisk(newDisks);
        console.log("🗑️ Disco eliminado.");
    }
}

// Menú principal
async function main() {
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });

    while (true) {
        console.log("\n=== CRUD de Compact Disks ===");
        console.log("1. Crear disco");
        console.log("2. Listar discos");
        console.log("3. Actualizar disco");
        console.log("4. Eliminar disco");
        console.log("5. Salir");

        const choice = await ask(rl, "Seleccione una opción: ");
        switch (choice) {
            case '1': await createCompactDisk(rl); break;
            case '2': listCompactDisks(); break;
            case '3': await updateCompactDisk(rl); break;
            case '4': await deleteCompactDisk(rl); break;
            case '5': rl.close(); return;
            default: console.log("❗ Opción inválida");
        }
    }
}

main();
