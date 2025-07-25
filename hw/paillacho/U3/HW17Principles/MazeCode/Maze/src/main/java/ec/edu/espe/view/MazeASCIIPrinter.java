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
            // Imprime muro superior de cada celda
            for (int x = 0; x < w; x++) {
                System.out.print(grid[y][x].hasWall(Direction.NORTH) ? "+---" : "+   ");
            }
            System.out.println("+");
            // Imprime paredes laterales y espacio interior
            for (int x = 0; x < w; x++) {
                System.out.print(grid[y][x].hasWall(Direction.WEST) ? "|   " : "    ");
            }
            System.out.println(grid[h-1][w-1].hasWall(Direction.EAST) ? "|" : " ");
        }
        // Imprime muro inferior final
        for (int x = 0; x < w; x++) {
            System.out.print("+---");
        }
        System.out.println("+");
    }
}

