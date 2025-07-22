package org.example.edu.ec.espe.maze.controller;

public class Door {
    private final Room firstRoom;
    private final Room secondRoom;

    public Door(Room firstRoom, Room secondRoom) {
        this.firstRoom = firstRoom;
        this.secondRoom = secondRoom;
    }

    public Room getFirstRoom() {
        return firstRoom;
    }

    public Room getSecondRoom() {
        return secondRoom;
    }
}
