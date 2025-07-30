
export class MazeGenerator {
    constructor(maze) {
        this.maze = maze;
    }

    generate() {
        const rows = this.maze.rows;
        const cols = this.maze.cols;
        const stack = [];
        const grid = this.maze.grid;

        let current = grid[0][0];
        current.visited = true;
        stack.push([0, 0]);

        while (stack.length > 0) {
            const [row, col] = stack.pop();
            const neighbors = this.getUnvisitedNeighbors(row, col);

            if (neighbors.length > 0) {
                stack.push([row, col]);
                const [nRow, nCol, direction] = neighbors[Math.floor(Math.random() * neighbors.length)];
                const neighbor = grid[nRow][nCol];
                neighbor.visited = true;

                this.removeWall(row, col, nRow, nCol, direction);
                stack.push([nRow, nCol]);
            }
        }
    }

    getUnvisitedNeighbors(row, col) {
        const neighbors = [];
        const grid = this.maze.grid;

        if (row > 0 && !grid[row - 1][col].visited) neighbors.push([row - 1, col, "top"]);
        if (row < this.maze.rows - 1 && !grid[row + 1][col].visited) neighbors.push([row + 1, col, "bottom"]);
        if (col > 0 && !grid[row][col - 1].visited) neighbors.push([row, col - 1, "left"]);
        if (col < this.maze.cols - 1 && !grid[row][col + 1].visited) neighbors.push([row, col + 1, "right"]);

        return neighbors;
    }

    removeWall(row, col, nRow, nCol, direction) {
        const grid = this.maze.grid;
        if (direction === "top") {
            grid[row][col].topWall = false;
            grid[nRow][nCol].bottomWall = false;
        } else if (direction === "bottom") {
            grid[row][col].bottomWall = false;
            grid[nRow][nCol].topWall = false;
        } else if (direction === "left") {
            grid[row][col].leftWall = false;
            grid[nRow][nCol].rightWall = false;
        } else if (direction === "right") {
            grid[row][col].rightWall = false;
            grid[nRow][nCol].leftWall = false;
        }
    }
}
