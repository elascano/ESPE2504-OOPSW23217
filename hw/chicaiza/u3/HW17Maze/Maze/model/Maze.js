import { Cell } from './Cell.js';

export class Maze {
  constructor(width, height) {
    this.width = width;
    this.height = height;
    this.cells = Array.from({ length: height }, () =>
      Array.from({ length: width }, () => new Cell())
    );
    this.generate();
  }

  generate() {
    this.startX = 0;
    this.startY = Math.floor(Math.random() * this.height);
    this.endX = this.width - 1;
    this.endY = Math.floor(Math.random() * this.height);

    this.cells[this.startY][this.startX].left = false;
    this.cells[this.endY][this.endX].right = false;

    this.dfs(this.startX, this.startY);
  }

  dfs(x, y) {
    this.cells[y][x].visited = true;
    const dirs = [
      [0, -1], [0, 1], [-1, 0], [1, 0]
    ].sort(() => Math.random() - 0.5);

    for (const [dx, dy] of dirs) {
      const nx = x + dx;
      const ny = y + dy;

      if (
        nx >= 0 && ny >= 0 &&
        nx < this.width && ny < this.height &&
        !this.cells[ny][nx].visited
      ) {
        if (dx === 1) {
          this.cells[y][x].right = false;
          this.cells[ny][nx].left = false;
        } else if (dx === -1) {
          this.cells[y][x].left = false;
          this.cells[ny][nx].right = false;
        } else if (dy === 1) {
          this.cells[y][x].bottom = false;
          this.cells[ny][nx].top = false;
        } else if (dy === -1) {
          this.cells[y][x].top = false;
          this.cells[ny][nx].bottom = false;
        }
        this.dfs(nx, ny);
      }
    }
  }

  getCells() {
    return this.cells;
  }

  getWidth() {
    return this.width;
  }

  getHeight() {
    return this.height;
  }
}