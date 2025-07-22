package org.example.edu.ec.espe.maze.controller;

import java.util.*;

public abstract class SettingMaze {
    protected int numberOfRows;
    protected int numberOfColumns;

    public SettingMaze(int numberOfRows, int numberOfColumns) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
    }

    public int getNumberOfRows() { return numberOfRows; }
    public int getNumberOfColumns() { return numberOfColumns; }

    /**
     *
     * @return Maze generated
     */
    public Maze generateMaze() {
        Maze maze = new Maze(numberOfRows, numberOfColumns);
        Room[][] rooms = maze.getRooms();
        boolean[][] visitedRooms = new boolean[numberOfRows][numberOfColumns];
        Random randomGenerator = new Random();

        int entranceRow = 0;
        int entranceColumn = randomGenerator.nextInt(numberOfColumns);
        int exitRow = numberOfRows - 1;
        int exitColumn = randomGenerator.nextInt(numberOfColumns);

        Room entranceRoom = rooms[entranceRow][entranceColumn];
        Room exitRoom = rooms[exitRow][exitColumn];
        maze.setEntrance(entranceRoom);
        maze.setExit(exitRoom);

        generateMazeDepthFirstSearch(entranceRoom, visitedRooms, rooms);

        // Cierra paredes exteriores y abre solo entrada y salida
        for (int column = 0; column < numberOfColumns; column++) {
            rooms[0][column].closeWall("UP");
            rooms[numberOfRows-1][column].closeWall("DOWN");
        }
        for (int row = 0; row < numberOfRows; row++) {
            rooms[row][0].closeWall("LEFT");
            rooms[row][numberOfColumns-1].closeWall("RIGHT");
        }
        entranceRoom.openWall("UP");
        exitRoom.openWall("DOWN");

        return maze;
    }

    private void generateMazeDepthFirstSearch(Room currentRoom, boolean[][] visitedRooms, Room[][] rooms) {
        int currentRow = currentRoom.getCoordinate().getRow();
        int currentColumn = currentRoom.getCoordinate().getCol();
        visitedRooms[currentRow][currentColumn] = true;
        List<String> directions = Arrays.asList("UP", "DOWN", "LEFT", "RIGHT");
        Collections.shuffle(directions);
        for (String direction : directions) {
            int nextRow = currentRow, nextColumn = currentColumn;
            switch (direction) {
                case "UP": nextRow = currentRow - 1; break;
                case "DOWN": nextRow = currentRow + 1; break;
                case "LEFT": nextColumn = currentColumn - 1; break;
                case "RIGHT": nextColumn = currentColumn + 1; break;
            }
            if (nextRow >= 0 && nextRow < numberOfRows && nextColumn >= 0 && nextColumn < numberOfColumns && !visitedRooms[nextRow][nextColumn]) {
                currentRoom.openWall(direction);
                rooms[nextRow][nextColumn].openWall(getOppositeDirection(direction));
                generateMazeDepthFirstSearch(rooms[nextRow][nextColumn], visitedRooms, rooms);
            }
        }
    }

    private String getOppositeDirection(String direction) {
        switch (direction) {
            case "UP": return "DOWN";
            case "DOWN": return "UP";
            case "LEFT": return "RIGHT";
            case "RIGHT": return "LEFT";
            default: return null;
        }
    }
}
