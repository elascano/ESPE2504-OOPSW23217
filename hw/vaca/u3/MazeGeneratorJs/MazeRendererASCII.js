import { MazeRoom } from "./MazeRoom.js";

export class MazeRendererASCII {
  render(maze) {
    const w = maze.getWidth();
    const h = maze.getHeight();

    for (let y = 0; y < h; y++) {
      let top = "", middle = "";

      for (let x = 0; x < w; x++) {
        top += "+";
        top += maze.getRoom(x, y).isOpen(MazeRoom.Direction.NORTH) ? "   " : "---";

        middle += maze.getRoom(x, y).isOpen(MazeRoom.Direction.WEST) ? " " : "|";
        if (x === 0 && y === 0) middle += " S ";
        else if (x === w - 1 && y === h - 1) middle += " E ";
        else middle += "   ";
      }

      console.log(top + "+");
      console.log(middle + "|");
    }

    console.log("+---".repeat(w) + "+");
  }
}
