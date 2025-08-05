import { Room } from './Room.js';
export class Maze {
  constructor(rows, cols) {
    this.rows = rows;
    this.cols = cols;
    this.grid = Array.from({ length: rows }, () => 
      Array.from({ length: cols }, () => new Room())
    );
  }

  getGrid() {
    return this.grid;
  }

  getRows() {
    return this.rows;
  }

  getCols() {
    return this.cols;
  }
}