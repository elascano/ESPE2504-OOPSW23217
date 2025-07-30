export class MazePrinter {
  print(maze) {
    const grid = maze.getGrid();
    const rows = maze.getRows();
    const cols = maze.getCols();

    let output = ' ';
    for (let j = 0; j < cols; j++) {
      output += ' _';
    }
    console.log(output);

    for (let i = 0; i < rows; i++) {
      let line = '|';
      for (let j = 0; j < cols; j++) {
        const room = grid[i][j];
        const bottom = room.bottomWall ? '_' : ' ';
        const right = room.rightWall ? '|' : ' ';

        if (i === 0 && j === 0) {
          line += 'S' + right; // Start
        } else if (i === rows - 1 && j === cols - 1) {
          line += 'E' + right; // End
        } else {
          line += bottom + right;
        }
      }
      console.log(line);
    }
  }
}