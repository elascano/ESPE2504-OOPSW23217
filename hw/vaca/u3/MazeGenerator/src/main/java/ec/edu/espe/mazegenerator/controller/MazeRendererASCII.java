package ec.edu.espe.mazegenerator.controller;

import ec.edu.espe.mazegenerator.model.Maze;
import ec.edu.espe.mazegenerator.model.MazeRoom;

/**
 *
 * @author Kevin Vaca Edison's OOP ESPE
 */
public class MazeRendererASCII implements MazeRenderer{

    @Override
    public void render(Maze maze) {
        int w = maze.getWidth();
        int h = maze.getHeight();

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                System.out.print("+");
                System.out.print(maze.getRoom(x, y).isOpen(MazeRoom.Direction.NORTH) ? "   " : "---");
            }
            System.out.println("+");

            for (int x = 0; x < w; x++) {
                System.out.print(maze.getRoom(x, y).isOpen(MazeRoom.Direction.WEST) ? " " : "|");
                if (x == 0 && y == 0) System.out.print(" S "); // Start
                else if (x == w - 1 && y == h - 1) System.out.print(" E "); // Exit
                else System.out.print("   ");
            }
            System.out.println("|");
        }

        for (int x = 0; x < w; x++) {
            System.out.print("+---");
        }
        System.out.println("+");
    }
}