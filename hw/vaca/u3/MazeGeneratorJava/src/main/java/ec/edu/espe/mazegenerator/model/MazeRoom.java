package ec.edu.espe.mazegenerator.model;
import java.util.EnumSet;

/**
 *
 * @author Kevin Vaca Edison's OOP ESPE
 */
public class MazeRoom {
    public enum Direction { NORTH, SOUTH, EAST, WEST }

    private EnumSet<Direction> openWalls;
    
    public MazeRoom() {
        openWalls = EnumSet.noneOf(Direction.class);
    }

    public void openWall(Direction dir) {
        openWalls.add(dir);
    }

    public boolean isOpen(Direction dir) {
        return openWalls.contains(dir);
    }

}
