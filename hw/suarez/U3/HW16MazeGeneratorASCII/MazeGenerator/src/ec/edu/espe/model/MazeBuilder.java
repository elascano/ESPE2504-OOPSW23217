package ec.edu.espe.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MazeBuilder {
    private Maze maze;
    private Random random = new Random();

    public MazeBuilder(Maze maze) {
        this.maze = maze;
    }

    public void generateMaze() {
        // Start with all walls closed and rooms unvisited
        for (int row = 0; row < maze.getRows(); row++) {
            for (int col = 0; col < maze.getCols(); col++) {
                maze.getRoom(row, col).setVisited(false);
                // Walls already closed by default in Room constructor
            }
        }

        // Pick entrance on top row, random column
        int entranceCol = random.nextInt(maze.getCols());
        Room entrance = maze.getRoom(0, entranceCol);
        maze.setEntrance(entrance);
        openExteriorDoor(entrance, Direction.NORTH);

        // Pick exit on bottom row, random column different from entrance
        int exitCol;
        do {
            exitCol = random.nextInt(maze.getCols());
        } while (exitCol == entranceCol);
        Room exit = maze.getRoom(maze.getRows() - 1, exitCol);
        maze.setExit(exit);
        openExteriorDoor(exit, Direction.SOUTH);

        // Start carving paths from entrance
        carvePaths(entrance);
    }

    private void openExteriorDoor(Room room, Direction dir) {
        // Replace wall with door and open it
        Door door = new Door(room, null); // null since exterior
        door.open();
        room.setWall(dir, door);
    }

    private void carvePaths(Room current) {
        current.setVisited(true);

        List<Direction> directions = new ArrayList<>();
        Collections.addAll(directions, Direction.values());
        Collections.shuffle(directions, random);

        for (Direction dir : directions) {
            int newRow = current.getRow();
            int newCol = current.getCol();

            switch (dir) {
                case NORTH -> newRow--;
                case SOUTH -> newRow++;
                case EAST -> newCol++;
                case WEST -> newCol--;
            }

            Room neighbor = maze.getRoom(newRow, newCol);

            if (neighbor != null && !neighbor.isVisited()) {
                // Carve door between current and neighbor
                Door door = new Door(current, neighbor);
                door.open();

                // Set door in both rooms’ walls (shared)
                current.setWall(dir, door);
                neighbor.setWall(Direction.opposite(dir), door);

                carvePaths(neighbor);
            }
        }
    }
}
