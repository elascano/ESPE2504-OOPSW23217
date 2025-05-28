const fs = require('fs');
const path = require('path');

class Table {
    constructor(id, material, color, size) {
        this.id = id;
        this.material = material;
        this.color = color;
        this.size = size;
    }

    guardarEnCSV() {
        const filePath = path.join(__dirname, 'data', 'tables.csv');
        const data = `${this.id},${this.material},${this.color},${this.size}\n`;
        
        fs.appendFile(filePath, data, (err) => {
            if (err) {
                console.error('Error al guardar en CSV:', err);
            } else {
                console.log('Tabla guardada en CSV:', this);
            }
        });
    }

    static leerDesdeCSV() {
        const filePath = path.join(__dirname, 'data', 'tables.csv');
        const tables = [];

        fs.readFile(filePath, 'utf8', (err, data) => {
            if (err) {
                console.error('Error:', err);
                return;
            }

            const lines = data.split('\n');
            for (const line of lines) {
                const [id, material, color, size] = line.split(',');
                if (id) { // Asegúrate de que la línea no esté vacía
                    tables.push(new Table(id, material, color, size));
                }
            }
            console.log('Tablet:', tables);
        });
    }
}

const table1 = new Table('001', 'Model', 'Green', 'Big');
table1.guardarEnCSV();
Table.leerDesdeCSV();


