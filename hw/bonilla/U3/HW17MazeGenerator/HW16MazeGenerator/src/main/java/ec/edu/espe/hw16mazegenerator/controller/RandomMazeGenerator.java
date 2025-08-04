package ec.edu.espe.hw16mazegenerator.controller;

import ec.edu.espe.hw16mazegenerator.model.Direction;
import ec.edu.espe.hw16mazegenerator.model.Room;
import java.util.*;

/**
 *
 * @author Bonilla David SoftCrafters
 */

public class RandomMazeGenerator implements MazeGenerator {

    @Override
    public void generate(Room[][] rooms) {
        Stack<Room> stack = new Stack<>();
        Room start = rooms[0][0];
        start.setVisited(true);
        stack.push(start);

        while (!stack.isEmpty()) {
            Room current = stack.peek();
            List<Direction> unvisitedNeighbors = getUnvisitedNeighbors(current, rooms);

            if (!unvisitedNeighbors.isEmpty()) {
                Direction dir = unvisitedNeighbors.get(new Random().nextInt(unvisitedNeighbors.size()));
                Room neighbor = getNeighbor(current, dir, rooms);

                current.getWall(dir).open();
                neighbor.getWall(Direction.opposite(dir)).open();

                neighbor.setVisited(true);
                stack.push(neighbor);
            } else {
                stack.pop();
            }
        }
    }

    private List<Direction> getUnvisitedNeighbors(Room room, Room[][] rooms) {
        List<Direction> neighbors = new ArrayList<>();

        for (Direction dir : Direction.values()) {
            Room neighbor = getNeighbor(room, dir, rooms);
            if (neighbor != null && !neighbor.isVisited()) {
                neighbors.add(dir);
            }
        }
        return neighbors;
    }

    private Room getNeighbor(Room room, Direction dir, Room[][] rooms) {
        int newRow = room.getRow() + dir.getRowOffset();
        int newCol = room.getCol() + dir.getColOffset();

        if (newRow >= 0 && newRow < rooms.length && newCol >= 0 && newCol < rooms[0].length) {
            return rooms[newRow][newCol];
        }
        return null;
    }
}
