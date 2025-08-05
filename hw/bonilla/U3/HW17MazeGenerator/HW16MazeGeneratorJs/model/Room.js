import { Direction } from './Direction.js';
import { Wall } from './Wall.js';

export class Room {
  constructor(row, col) {
    this.row = row;
    this.col = col;
    this.visited = false;
    this.walls = new Map();
    Direction.all().forEach(dir => {
      this.walls.set(dir.name, new Wall());
    });
  }

  getWall(dir) {
    return this.walls.get(dir.name);
  }

  setVisited(value) {
    this.visited = value;
  }

  isVisited() {
    return this.visited;
  }
}
