package ec.edu.espe.hw16mazegenerator.model;

import java.util.EnumMap;
import java.util.Map;

/**
 *
 * @author Bonilla David SoftCrafters
 */

public class Room {

    private final int row;
    private final int col;
    private final Map<Direction, Wall> walls;
    private boolean visited;

    public Room(int row, int col) {
        this.row = row;
        this.col = col;
        this.visited = false;
        this.walls = new EnumMap<>(Direction.class);
        for (Direction dir : Direction.values()) {
            walls.put(dir, new Wall());
        }
    }

    public Wall getWall(Direction dir) {
        return walls.get(dir);
    }

    public void setWall(Direction dir, Wall wall) {
        walls.put(dir, wall);
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
