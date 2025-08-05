package ec.edu.espe.hw16mazegenerator.model;

import ec.edu.espe.hw16mazegenerator.controller.MazeGenerator;
import ec.edu.espe.hw16mazegenerator.controller.MazePrinter;
import ec.edu.espe.hw16mazegenerator.controller.RandomMazeGenerator;

/**
 *
 * @author Mateo Unda
 */
public class Maze {

    private final Room[][] rooms;

    public Maze(int rows, int cols) {
        rooms = new Room[rows][cols];
        initializeRooms();
        generateMaze();
    }

    private void initializeRooms() {
        for (int row = 0; row < rooms.length; row++) {
            for (int col = 0; col < rooms[0].length; col++) {
                rooms[row][col] = new Room(row, col);
            }
        }
    }

    private void generateMaze() {
        MazeGenerator generator = new RandomMazeGenerator();
        generator.generate(rooms);

        // Abrir entrada y salida
        rooms[0][0].getWall(Direction.WEST).open(); // Entrada
        rooms[rooms.length - 1][rooms[0].length - 1].getWall(Direction.EAST).open(); // Salida
    }

    public void display() {
        MazePrinter printer = new MazePrinter(rooms);
        printer.print();
    }
}
