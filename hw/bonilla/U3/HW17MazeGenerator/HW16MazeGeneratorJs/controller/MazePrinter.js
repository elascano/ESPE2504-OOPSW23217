import { Direction } from '../model/Direction.js';

export class MazePrinter {
  constructor(rooms) {
    this.rooms = rooms;
  }

  print() {
    const rows = this.rooms.length;
    const cols = this.rooms[0].length;

    for (let r = 0; r < rows; r++) {
      let top = '';
      for (let c = 0; c < cols; c++) {
        top += '+';
        top += this.rooms[r][c].getWall(Direction.NORTH).isOpen() ? '   ' : '---';
      }
      top += '+';
      console.log(top);

      let middle = '';
      for (let c = 0; c < cols; c++) {
        if (r === 0 && c === 0) {
          middle += 'E';
        } else {
          middle += this.rooms[r][c].getWall(Direction.WEST).isOpen() ? ' ' : '|';
        }

        middle += '   ';

        if (r === rows - 1 && c === cols - 1) {
          middle += 'S';
        } else if (c === cols - 1) {
          middle += this.rooms[r][c].getWall(Direction.EAST).isOpen() ? ' ' : '|';
        }
      }
      console.log(middle);
    }

    let bottom = '';
    for (let c = 0; c < this.rooms[0].length; c++) {
      bottom += '+---';
    }
    bottom += '+';
    console.log(bottom);
  }
}
