import { Maze } from '../model/Maze.js';

export class MazeController {
  constructor(width, height, view) {
    this.maze = new Maze(width, height);
    this.view = view;
  }

  displayMaze() {
    this.view.show(this.maze);
  }
}