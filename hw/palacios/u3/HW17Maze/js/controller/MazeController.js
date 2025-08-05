import { Maze } from '../model/Maze.js';
import { MazeGenerator } from '../model/MazeGenerator.js';
import { MazePrinter } from '../view/MazePrinter.js';

export class MazeController {
  constructor(rows, cols) {
    this.maze = new Maze(rows, cols);
    this.generator = new MazeGenerator(this.maze);
    this.printer = new MazePrinter();
  }

  run() {
    this.generator.generate();
    this.maze.getGrid()[0][0].leftWall = false; // Entrada
    const lastRow = this.maze.getRows() - 1;
    const lastCol = this.maze.getCols() - 1;
    this.maze.getGrid()[lastRow][lastCol].rightWall = false; // Salida
    this.printer.print(this.maze);
  }
}