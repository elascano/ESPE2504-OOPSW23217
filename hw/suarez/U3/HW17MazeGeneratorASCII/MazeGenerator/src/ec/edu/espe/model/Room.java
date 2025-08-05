package ec.edu.espe.model;

import java.util.EnumMap;

public class Room {
    private final EnumMap<Direction, Wall> walls;
    private boolean visited;
    private final int row;
    private final int col;

    public Room(int row, int col) {
        this.row = row;
        this.col = col;
        this.walls = new EnumMap<>(Direction.class);
        this.visited = false;
        for (Direction dir : Direction.values()) {
            walls.put(dir, new Wall());
        }
    }

    public Wall getWall(Direction direction) {
        return walls.get(direction);
    }

    public void setWall(Direction direction, Wall wall) {
        walls.put(direction, wall);
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
