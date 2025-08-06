import readline from 'readline';
import { Maze } from '../model/Maze.js';

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

rl.question('Ingrese número de filas: ', (rowsInput) => {
  rl.question('Ingrese número de columnas: ', (colsInput) => {
    const rows = parseInt(rowsInput);
    const cols = parseInt(colsInput);

    if (isNaN(rows) || isNaN(cols) || rows < 1 || cols < 1) {
      console.log('Dimensiones inválidas.');
      rl.close();
      return;
    }

    const maze = new Maze(rows, cols);
    maze.display();

    rl.close();
  });
});
