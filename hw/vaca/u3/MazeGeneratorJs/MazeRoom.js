export class MazeRoom {
  static Direction = { NORTH: "NORTH", SOUTH: "SOUTH", EAST: "EAST", WEST: "WEST" };

  constructor() {
    this.openWalls = new Set();
  }

  openWall(dir) {
    this.openWalls.add(dir);
  }

  isOpen(dir) {
    return this.openWalls.has(dir);
  }
}
