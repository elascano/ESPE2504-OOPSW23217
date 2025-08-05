
export function printMaze(maze) {
    const rows = maze.rows;
    const cols = maze.cols;
    const grid = maze.grid;

    for (let i = 0; i < rows; i++) {
        let top = "";
        let middle = "";
        for (let j = 0; j < cols; j++) {
            top += grid[i][j].topWall ? "+---" : "+   ";
            middle += grid[i][j].leftWall ? "|   " : "    ";
        }
        console.log(top + "+");
        console.log(middle + "|");
    }

    // Last row
    let bottom = "";
    for (let j = 0; j < cols; j++) {
        bottom += "+---";
    }
    console.log(bottom + "+");
}
