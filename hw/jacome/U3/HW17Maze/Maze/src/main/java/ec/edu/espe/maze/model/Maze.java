package ec.edu.espe.maze.model;

/**
 *
 * @author Micaela Jácome
 */
public class Maze {
    //single responsability principle
    private final int rows;
    private final int cols;
    private final Room[][] grid;

    public Maze(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.grid = new Room[rows][cols];
        initialize();
    }

    private void initialize() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = new Room();
            }
        }
    }

    public Room[][] getGrid() {
        return grid;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
}
