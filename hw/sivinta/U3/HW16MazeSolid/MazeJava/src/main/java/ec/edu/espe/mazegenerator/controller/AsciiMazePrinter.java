
package ec.edu.espe.mazegenerator.controller;

import ec.edu.espe.mazegenerator.model.Maze;
import ec.edu.espe.mazegenerator.model.Room;

/**
 *
 * @author Isaac Maisincho Crafters_Market DCCO ESPE
 */
public class AsciiMazePrinter implements MazePrinter{
     @Override
    public void print(Maze maze) {
        Room[][] rooms = maze.getRooms();
        int width = rooms.length;
        int height = rooms[0].length;

        for (int y = 0; y < height; y++) {
            final int finalY = y; 
            for (int x = 0; x < width; x++) {
                final int finalX = x; 
                System.out.print("+");
                if (rooms[finalX][finalY].getDoors().stream().anyMatch(door -> door.getRoom1().getY() == finalY && door.getRoom2().getY() == finalY + 1)) {
                    System.out.print("   ");
                } else {
                    System.out.print("---");
                }
            }
            System.out.println("+");

            for (int x = 0; x < width; x++) {
                final int finalX = x; 
                if (rooms[finalX][finalY].getDoors().stream().anyMatch(door -> door.getRoom1().getX() == finalX && door.getRoom2().getX() == finalX + 1)) {
                    System.out.print(" ");
                } else {
                    System.out.print("|");
                }
                System.out.print("   ");
            }
            System.out.println("|");
        }

        for (int x = 0; x < width; x++) {
            System.out.print("+---");
        }
        System.out.println("+");
    }
}
