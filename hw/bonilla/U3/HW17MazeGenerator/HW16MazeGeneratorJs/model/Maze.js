import { Room } from './Room.js';
import { RandomMazeGenerator } from '../controller/RandomMazeGenerator.js';
import { MazePrinter } from '../controller/MazePrinter.js';

export class Maze {
  constructor(rows, cols) {
    this.rooms = Array.from({ length: rows }, (_, r) =>
      Array.from({ length: cols }, (_, c) => new Room(r, c))
    );

    const generator = new RandomMazeGenerator();
    generator.generate(this.rooms);

    // Abrir entrada y salida
    this.rooms[0][0].getWall({ name: 'WEST' }).openWall();
    this.rooms[rows - 1][cols - 1].getWall({ name: 'EAST' }).openWall();
  }

  display() {
    
    new MazePrinter(this.rooms).print();
  }
}
