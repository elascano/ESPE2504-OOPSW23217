import readline from 'readline';
import { MazeConsoleView } from './view/MazeConsoleView.js';
import { MazeController } from './controller/MazeController.js';

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

rl.question('Ingrese el ancho (N): ', (widthStr) => {
  rl.question('Ingrese la altura (M): ', (heightStr) => {
    const width = parseInt(widthStr);
    const height = parseInt(heightStr);
    const controller = new MazeController(width, height, new MazeConsoleView());
    controller.displayMaze();
    rl.close();
  });
});