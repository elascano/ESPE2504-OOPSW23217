import { Room } from './Room.js';

export class MazeGenerator {
  constructor(maze) {
    this.maze = maze;
    this.random = Math.random;
  }

  generate() {
    this.generateMaze(0, 0);
  }

  generateMaze(row, col) {
    const grid = this.maze.getGrid();
    grid[row][col].visited = true;

    const directions = [[-1, 0], [1, 0], [0, -1], [0, 1]];
    this.shuffle(directions);

    for (const [dx, dy] of directions) {
      const newRow = row + dx;
      const newCol = col + dy;

      if (this.isValid(newRow, newCol)) {
        if (!grid[newRow][newCol].visited) {
          this.removeWalls(grid[row][col], grid[newRow][newCol], [dx, dy]);
          this.generateMaze(newRow, newCol);
        }
      }
    }
  }

  shuffle(array) {
    for (let i = array.length - 1; i > 0; i--) {
      const j = Math.floor(this.random() * (i + 1));
      [array[i], array[j]] = [array[j], array[i]];
    }
  }

  isValid(r, c) {
    return r >= 0 && c >= 0 && r < this.maze.getRows() && c < this.maze.getCols();
  }

  removeWalls(current, next, [dx, dy]) {
    if (dx === -1) { // Up
      current.topWall = false;
      next.bottomWall = false;
    } else if (dx === 1) { // Down
      current.bottomWall = false;
      next.topWall = false;
    } else if (dy === -1) { // Left
      current.leftWall = false;
      next.rightWall = false;
    } else if (dy === 1) { // Right
      current.rightWall = false;
      next.leftWall = false;
    }
  }
}