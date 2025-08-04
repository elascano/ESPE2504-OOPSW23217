import { MazeDisplay } from './MazeDisplay.js';

export class MazeConsoleView extends MazeDisplay {
  show(maze) {
    const cells = maze.getCells();
    const height = maze.getHeight();
    const width = maze.getWidth();

    for (let y = 0; y < height; y++) {
      let topLine = '';
      let midLine = '';
      for (let x = 0; x < width; x++) {
        topLine += '+' + (cells[y][x].top ? '---' : '   ');
        midLine += (cells[y][x].left ? '|' : ' ') + '   ';
      }
      topLine += '+';
      midLine += cells[y][width - 1].right ? '|' : ' ';
      console.log(topLine);
      console.log(midLine);

      if (y === height - 1) {
        let bottomLine = '';
        for (let x = 0; x < width; x++) {
          bottomLine += '+' + (cells[y][x].bottom ? '---' : '   ');
        }
        bottomLine += '+';
        console.log(bottomLine);
      }
    }
  }
}