import { Direction } from '../model/Direction.js';

export class RandomMazeGenerator {
  generate(rooms) {
    const stack = [];
    const start = rooms[0][0];
    start.setVisited(true);
    stack.push(start);

    while (stack.length > 0) {
      const current = stack[stack.length - 1];
      const neighbors = this.getUnvisitedNeighbors(current, rooms);

      if (neighbors.length > 0) {
        const { dir, neighbor } = neighbors[Math.floor(Math.random() * neighbors.length)];

        current.getWall(dir).openWall();
        neighbor.getWall(Direction.opposite(dir)).openWall();

        neighbor.setVisited(true);
        stack.push(neighbor);
      } else {
        stack.pop();
      }
    }
  }

  getUnvisitedNeighbors(room, rooms) {
    const neighbors = [];

    for (const dir of Direction.all()) {
      const newRow = room.row + dir.rowOffset;
      const newCol = room.col + dir.colOffset;

      if (
        newRow >= 0 && newRow < rooms.length &&
        newCol >= 0 && newCol < rooms[0].length &&
        !rooms[newRow][newCol].isVisited()
      ) {
        neighbors.push({ dir, neighbor: rooms[newRow][newCol] });
      }
    }

    return neighbors;
  }
}
