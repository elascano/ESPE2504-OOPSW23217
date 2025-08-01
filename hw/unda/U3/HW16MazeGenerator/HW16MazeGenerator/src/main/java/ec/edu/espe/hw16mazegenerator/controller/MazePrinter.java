package ec.edu.espe.hw16mazegenerator.controller;

import ec.edu.espe.hw16mazegenerator.model.Direction;
import ec.edu.espe.hw16mazegenerator.model.Room;

/**
 *
 * @author Mateo Unda
 */
public class MazePrinter {

    private final Room[][] rooms;

    public MazePrinter(Room[][] rooms) {
        this.rooms = rooms;
    }

    public void print() {
        int rows = rooms.length;
        int cols = rooms[0].length;

        for (int row = 0; row < rows; row++) {
            // Parte superior de cada celda (techo)
            for (int col = 0; col < cols; col++) {
                System.out.print("+");
                System.out.print(rooms[row][col].getWall(Direction.NORTH).isOpen() ? "   " : "---");
            }
            System.out.println("+");

            // Parte central: paredes laterales y contenido
            for (int col = 0; col < cols; col++) {
                if (row == 0 && col == 0) {
                    System.out.print("E"); // entrada
                } else {
                    System.out.print(rooms[row][col].getWall(Direction.WEST).isOpen() ? " " : "|");
                }

                System.out.print("   ");

                if (row == rows - 1 && col == cols - 1) {
                    System.out.print("S"); // salida
                } else if (col == cols - 1) {
                    System.out.print(rooms[row][col].getWall(Direction.EAST).isOpen() ? " " : "|");
                }
            }

            System.out.println();
        }

        // Parte inferior final (Sur)
        for (int col = 0; col < cols; col++) {
            System.out.print("+---");
        }
        System.out.println("+");
    }
}
