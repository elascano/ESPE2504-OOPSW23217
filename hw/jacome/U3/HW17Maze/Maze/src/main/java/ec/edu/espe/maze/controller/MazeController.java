package ec.edu.espe.maze.controller;

import ec.edu.espe.maze.model.Room;
import ec.edu.espe.maze.model.Maze;
import ec.edu.espe.maze.model.MazeGenerator;
import ec.edu.espe.maze.view.MazePrinter;

/**
 *
 * @author Micaela Jácome
 */

/*
Single Responsibility Principle
Dependency Inversion Principle
 */
public class MazeController {

    private final Maze maze;
    private final MazeGenerator generator;
    private final MazePrinter printer;

    public MazeController(int rows, int cols) {
        this.maze = new Maze(rows, cols);
        this.generator = new MazeGenerator(maze);
        this.printer = new MazePrinter();
    }

    public void run() {
        generator.generate();
        maze.getGrid()[0][0].leftWall = false;

        int lastRow = maze.getRows() - 1;
        int lastCol = maze.getCols() - 1;
        maze.getGrid()[lastRow][lastCol].rightWall = false;

        printer.print(maze);
    }

}
