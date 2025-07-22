package org.example.edu.ec.espe.maze.controller;

import java.util.List;

public class Path {
    private final List<Room> roomsInPath;

    public Path(List<Room> roomsInPath) {
        this.roomsInPath = roomsInPath;
    }

    public List<Room> getRoomsInPath() {
        return roomsInPath;
    }
}
