package ec.edu.espe.maze.model;
import java.util.Random;
/**
 *
 * @author Micaela Jácome
 */

/*Single Responsability Principle
Open/ Closed Principle
Dependency Inversion Principle
*/

public class MazeGenerator {
    private final Maze maze;
    private final Random random = new Random();

    public MazeGenerator(Maze maze) {
        this.maze = maze;
    }

    public void generate() {
        generateMaze(0, 0); 
    }

    private void generateMaze(int row, int col) {
        Room[][] grid = maze.getGrid();
        grid[row][col].visited = true;

        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        shuffle(directions);

        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (isValid(newRow, newCol)) {
                if (!grid[newRow][newCol].visited) {
                    removeWalls(grid[row][col], grid[newRow][newCol], dir);
                    generateMaze(newRow, newCol);
                }
            }
        }
    }

    private void shuffle(int[][] array) {
        for (int i = array.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int[] temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    private boolean isValid(int r, int c) {
        return r >= 0 && c >= 0 && r < maze.getRows() && c < maze.getCols();
    }

    private void removeWalls(Room current, Room next, int[] dir) {
        if (dir[0] == -1) { // up
            current.topWall = false;
            next.bottomWall = false;
        } else if (dir[0] == 1) { // down
            current.bottomWall = false;
            next.topWall = false;
        } else if (dir[1] == -1) { // left
            current.leftWall = false;
            next.rightWall = false;
        } else if (dir[1] == 1) { // right
            current.rightWall = false;
            next.leftWall = false;
        }
    }
}
