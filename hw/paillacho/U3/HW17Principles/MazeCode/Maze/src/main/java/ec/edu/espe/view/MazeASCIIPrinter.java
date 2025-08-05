package ec.edu.espe.view;

import ec.edu.espe.model.MazeModel;
import ec.edu.espe.controller.Direction;
import ec.edu.espe.controller.Room;
/**
 *
 * @author Carlos Paillacho
 */
public class MazeASCIIPrinter implements MazeRenderer {
    @Override
    public void render(MazeModel maze) {
        int w = maze.getWidth();
        int h = maze.getHeight();
        Room[][] grid = maze.getGrid();
        for (int y = 0; y < h; y++) {

            for (int x = 0; x < w; x++) {
                System.out.print(grid[y][x].hasWall(Direction.NORTH) ? "+---" : "+   ");
            }
            System.out.println("+");

            for (int x = 0; x < w; x++) {
                System.out.print(grid[y][x].hasWall(Direction.WEST) ? "|   " : "    ");
            }
            System.out.println(grid[h-1][w-1].hasWall(Direction.EAST) ? "|" : " ");
        }

        for (int x = 0; x < w; x++) {
            System.out.print("+---");
        }
        System.out.println("+");
    }
}

