const fs = require('fs');
const readline = require('readline');

class CompactDisc {
    constructor(id, brand, capacity, usedSpace, type) {
        this.id = id;
        this._brand = brand;
        this._capacity = capacity;     // en MB
        this._usedSpace = usedSpace;   // en MB
        this._type = type;             // ej. "CD-R", "CD-RW"
    }

    get brand() {
        return this._brand;
    }

    get capacity() {
        return this._capacity;
    }

    get usedSpace() {
        return this._usedSpace;
    }

    get type() {
        return this._type;
    }

    set brand(newBrand) {
        this._brand = newBrand;
    }

    set capacity(newCapacity) {
        this._capacity = newCapacity;
    }

    set usedSpace(newUsedSpace) {
        this._usedSpace = newUsedSpace;
    }

    set type(newType) {
        this._type = newType;
    }
}

class ReadDisc {
    static read(filename) {
        try {
            const jsonString = fs.readFileSync(filename, 'utf8');
            const discData = JSON.parse(jsonString);
            return discData.map(d => new CompactDisc(d.id, d._brand, d._capacity, d._usedSpace, d._type));
        } catch (error) {
            throw new Error(`Error reading ${filename}: ${error.message}`);
        }
    }
}

class SaveDisc {
    static save(discs, filename) {
        if (!Array.isArray(discs) || !discs.every(d => d instanceof CompactDisc)) {
            throw new Error("The object to save is not an array of CompactDisc instances.");
        }
        const json = JSON.stringify(discs);
        fs.writeFileSync(filename, json);
        console.log(`Discs saved to ${filename}`);
    }
}

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

function askQuestion(query) {
    return new Promise(resolve => rl.question(query, resolve));
}

async function main() {
    const discs = [];
    let id = 1;

    while (true) {
        const brand = await askQuestion(`Enter brand for disc ${id}: `);
        const capacity = await askQuestion(`Enter capacity in MB for disc ${id}: `);
        const usedSpace = await askQuestion(`Enter used space in MB for disc ${id}: `);
        const type = await askQuestion(`Enter type (e.g., CD-R, CD-RW) for disc ${id}: `);

        discs.push(new CompactDisc(id, brand, parseFloat(capacity), parseFloat(usedSpace), type));

        const another = await askQuestion('Do you want to add another disc? (yes/no): ');
        if (another.toLowerCase() !== 'yes') {
            break;
        }

        id++;
    }

    const filename = 'compact_discs.json';
    SaveDisc.save(discs, filename);

    const readDiscs = ReadDisc.read(filename);

    console.log("Read Discs:", readDiscs);

    rl.close();
}

main();
