package org.example.edu.ec.espe.maze.controller;

import org.example.edu.ec.espe.maze.model.Coordinate;
import org.example.edu.ec.espe.maze.model.Wall;
import java.util.HashMap;
import java.util.Map;

public class Room {
    private final Coordinate coordinate;
    private final Map<String, Wall> walls;
    private boolean isEntranceRoom;
    private boolean isExitRoom;

    public Room(Coordinate coordinate) {
        this.coordinate = coordinate;
        this.walls = new HashMap<>();
        this.isEntranceRoom = false;
        this.isExitRoom = false;
        walls.put("UP", new Wall(false));
        walls.put("DOWN", new Wall(false));
        walls.put("LEFT", new Wall(false));
        walls.put("RIGHT", new Wall(false));
    }

    public Coordinate getCoordinate() { return coordinate; }
    public void openWall(String direction) { if (walls.containsKey(direction)) walls.get(direction).setOpen(true); }
    public void closeWall(String direction) { if (walls.containsKey(direction)) walls.get(direction).setOpen(false); }
    public boolean hasDoor(String direction) { return walls.containsKey(direction) && walls.get(direction).isOpen(); }
    public boolean isEntrance() { return isEntranceRoom; }
    public void setEntrance(boolean isEntranceRoom) { this.isEntranceRoom = isEntranceRoom; }
    public boolean isExit() { return isExitRoom; }
    public void setExit(boolean isExitRoom) { this.isExitRoom = isExitRoom; }
    public String getDisplaySymbol() { return isEntrance() ? "S" : isExit() ? "E" : " "; }
    public boolean hasWall(String direction) { return !hasDoor(direction); }
}
