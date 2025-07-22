package org.example.edu.ec.espe.maze.controller;

import org.example.edu.ec.espe.maze.model.Coordinate;

public class Maze {
    private final int numberOfRows;
    private final int numberOfColumns;
    private final Room[][] rooms;
    private Room entranceRoom;
    private Room exitRoom;

    public Maze(int numberOfRows, int numberOfColumns) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
        this.rooms = new Room[numberOfRows][numberOfColumns];
        for (int row = 0; row < numberOfRows; row++)
            for (int column = 0; column < numberOfColumns; column++)
                rooms[row][column] = new Room(new Coordinate(row, column));
    }

    public Room[][] getRooms() { return rooms; }
    public void setEntrance(Room entranceRoom) { this.entranceRoom = entranceRoom; if (entranceRoom != null) entranceRoom.setEntrance(true); }
    public void setExit(Room exitRoom) { this.exitRoom = exitRoom; if (exitRoom != null) exitRoom.setExit(true); }


    public void display() {
        for (int column = 0; column < numberOfColumns; column++) {
            System.out.print("+");
            System.out.print(rooms[0][column].hasDoor("UP") ? " " : "-");
        }
        System.out.println("+");
        for (int row = 0; row < numberOfRows; row++) {
            for (int column = 0; column < numberOfColumns; column++) {
                System.out.print(rooms[row][column].hasDoor("LEFT") ? " " : "|");
                System.out.print(rooms[row][column].getDisplaySymbol());
            }
            System.out.println("|");
            for (int column = 0; column < numberOfColumns; column++) {
                System.out.print("+");
                System.out.print(rooms[row][column].hasDoor("DOWN") ? " " : "-");
            }
            System.out.println("+");
        }
    }
}
