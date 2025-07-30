package ec.edu.espe.controller;

import java.util.EnumMap;
/**
 *
 * @author Carlos Paillacho
 */
public class Room {
    private final int x;
    private final int y;
    private final EnumMap<Direction, Boolean> walls;
    private final EnumMap<Direction, Door> doors;

    public Room(int x, int y) {
        this.x = x;
        this.y = y;
        walls = new EnumMap<>(Direction.class);
        doors = new EnumMap<>(Direction.class);
        for (Direction dir : Direction.values()) {
            walls.put(dir, true);
        }
    }

    public void openWall(Direction direction) {
        walls.put(direction, false);
    }

    public boolean hasWall(Direction direction) {
        return walls.get(direction);
    }

    public void setDoor(Direction direction, Door door) {
        doors.put(direction, door);
    }

    public Door getDoor(Direction direction) {
        return doors.get(direction);
    }

    public int getX() { return x; }
    public int getY() { return y; }
}