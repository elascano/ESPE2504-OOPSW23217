import { Maze } from "./Maze.js";
import { MazeRoom } from "./MazeRoom.js";

export class DFSMazeGenerator {
  generate(width, height) {
    const maze = new Maze(width, height);
    const visited = Array.from({ length: height }, () => Array(width).fill(false));
    this.dfs(0, 0, maze, visited);
    return maze;
  }

  dfs(x, y, maze, visited) {
    visited[y][x] = true;
    const directions = this.shuffle(Object.values(MazeRoom.Direction));

    for (const dir of directions) {
      let nx = x, ny = y;

      switch (dir) {
        case "NORTH": ny--; break;
        case "SOUTH": ny++; break;
        case "EAST": nx++; break;
        case "WEST": nx--; break;
      }

      if (nx >= 0 && ny >= 0 && ny < maze.getHeight() && nx < maze.getWidth() && !visited[ny][nx]) {
        maze.getRoom(x, y).openWall(dir);
        maze.getRoom(nx, ny).openWall(this.opposite(dir));
        this.dfs(nx, ny, maze, visited);
      }
    }
  }

  opposite(dir) {
    const { NORTH, SOUTH, EAST, WEST } = MazeRoom.Direction;
    return {
      [NORTH]: SOUTH,
      [SOUTH]: NORTH,
      [EAST]: WEST,
      [WEST]: EAST
    }[dir];
  }

  shuffle(array) {
    return array.sort(() => Math.random() - 0.5);
  }
}
