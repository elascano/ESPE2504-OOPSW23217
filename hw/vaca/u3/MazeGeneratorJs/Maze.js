import { MazeRoom } from "./MazeRoom.js";

export class Maze {
  constructor(width, height) {
    this.width = width;
    this.height = height;
    this.rooms = Array.from({ length: height }, () =>
      Array.from({ length: width }, () => new MazeRoom())
    );
  }

  getWidth() {
    return this.width;
  }

  getHeight() {
    return this.height;
  }

  getRoom(x, y) {
    return this.rooms[y][x];
  }
}
