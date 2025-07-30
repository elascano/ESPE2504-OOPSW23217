package ec.edu.espe.maze.view;

import ec.edu.espe.maze.model.Room;
import ec.edu.espe.maze.model.Maze;

/**
 *
 * @author Daniel Palacios
 */
public class MazePrinter {

    public void print(Maze maze) {
        Room[][] grid = maze.getGrid();
        int rows = maze.getRows();
        int cols = maze.getCols();

        System.out.print(" ");
        for (int j = 0; j < cols; j++) {
            System.out.print(" _");
        }
        System.out.println();

        for (int i = 0; i < rows; i++) {
            System.out.print("|");
            for (int j = 0; j < cols; j++) {
                Room room = grid[i][j];

                String bottom = room.bottomWall ? "_" : " ";

                String right = room.rightWall ? "|" : " ";

                if (i == 0 && j == 0) {
                    System.out.print("S" + right);
                } else if (i == rows - 1 && j == cols - 1) {
                    System.out.print("E" + right);
                } else {
                    System.out.print(bottom + right);
                }
            }
            System.out.println();
        }
    }
}
