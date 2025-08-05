package ec.edu.espe.controller;

import ec.edu.espe.model.*;

public class MazeController {
    private Maze maze;
    private MazeBuilder builder;

    public void createMaze(int rows, int cols) {
        maze = new Maze(rows, cols);
        builder = new MazeBuilder(maze);
        builder.generateMaze();
    }

    public Maze getMaze() {
        return maze;
    }

    // print ASCII
    public void printMazeAscii() {
        for (int row = 0; row < maze.getRows(); row++) {
            // top walls
            for (int col = 0; col < maze.getCols(); col++) {
                System.out.print("+");
                Wall topWall = maze.getRoom(row, col).getWall(Direction.NORTH);
                System.out.print(topWall.isOpen() ? "   " : "---");
            }
            System.out.println("+");

            // side walls and space
            for (int col = 0; col < maze.getCols(); col++) {
                Wall leftWall = maze.getRoom(row, col).getWall(Direction.WEST);
                System.out.print(leftWall.isOpen() ? " " : "|");

                // entrance (E) and exit (X)
                Room room = maze.getRoom(row, col);
                if (room == maze.getEntrance()) {
                    System.out.print(" E ");
                } else if (room == maze.getExit()) {
                    System.out.print(" X ");
                } else {
                    System.out.print("   ");
                }
            }

            // last wall to the right
            Wall rightWall = maze.getRoom(row, maze.getCols() - 1).getWall(Direction.EAST);
            System.out.println(rightWall.isOpen() ? " " : "|");
        }

        // bottom walls
        for (int col = 0; col < maze.getCols(); col++) {
            System.out.print("+");
            Wall bottomWall = maze.getRoom(maze.getRows() - 1, col).getWall(Direction.SOUTH);
            System.out.print(bottomWall.isOpen() ? "   " : "---");
        }
        System.out.println("+");
    }
}