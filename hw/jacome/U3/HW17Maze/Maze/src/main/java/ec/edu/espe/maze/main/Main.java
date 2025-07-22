package ec.edu.espe.maze.main;

import ec.edu.espe.maze.model.Maze;
import ec.edu.espe.maze.model.MazeGenerator;
import ec.edu.espe.maze.view.MazePrinter;
/**
 *
 * @author Micaela Jacome DESKTOP-46VMNHU ESPE
 */
public class Main {

    public static void main(String[] args) {
        int rows = 6;
        int cols = 6;

        Maze maze = new Maze(rows, cols);
        MazeGenerator generator = new MazeGenerator(maze);
        generator.generate();

        MazePrinter printer = new MazePrinter();
        printer.print(maze);
    }
}
