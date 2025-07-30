package ec.edu.espe.model;

import ec.edu.espe.controller.Entrance;
import ec.edu.espe.controller.Exit;
import ec.edu.espe.controller.Path;
import ec.edu.espe.controller.Room;
/**
 *
 * @author Carlos Paillacho
 */
public class MazeModel {
    private final int width;
    private final int height;
    private final Room[][] grid;
    private Entrance entrance;
    private Exit exit;
    private Path path;

    public MazeModel(int width, int height) {
        this.width = width;
        this.height = height;
        this.grid = new Room[height][width];
    }

    public void setRoom(int x, int y, Room room) {
        grid[y][x] = room;
    }

    public Room getRoom(int x, int y) {
        return grid[y][x];
    }

    public void setEntrance(Entrance entrance) { this.entrance = entrance; }
    public void setExit(Exit exit) { this.exit = exit; }
    public void setPath(Path path) { this.path = path; }

    public int getWidth() { return width; }
    public int getHeight() { return height; }
    public Room[][] getGrid() { return grid; }
    public Entrance getEntrance() { return entrance; }
    public Exit getExit() { return exit; }
    public Path getPath() { return path; }
}
