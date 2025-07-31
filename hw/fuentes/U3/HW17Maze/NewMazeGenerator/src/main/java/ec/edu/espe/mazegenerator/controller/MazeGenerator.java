/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.mazegenerator.controller;

import ec.edu.espe.mazegenerator.model.EntranceDoor;
import ec.edu.espe.mazegenerator.model.ExitDoor;
import ec.edu.espe.mazegenerator.model.InnerDoor;
import ec.edu.espe.mazegenerator.model.Maze;
import ec.edu.espe.mazegenerator.model.Room;
import ec.edu.espe.mazegenerator.model.Wall;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author jorge
 */
public class MazeGenerator {
     public Maze generateMaze(int N, int M) {
        Maze maze = new Maze(N, M);
        addDefaultWalls(maze); 

        Set<Room> visited = new HashSet<>();
        Stack<Room> stack = new Stack<>();

        Room start = maze.getRoom(0, 0);
        Room end = maze.getRoom(N - 1, M - 1);

        maze.setEntrance(start);
        maze.setExit(end);

        visited.add(start);
        stack.push(start);

        while (!stack.isEmpty()) {
            Room current = stack.peek();
            List<Room> neighbors = getUnvisitedNeighbors(maze, current, visited);

            if (!neighbors.isEmpty()) {
                Room next = neighbors.get(new Random().nextInt(neighbors.size()));
                removeWallBetween(current, next);
                createInnerDoor(current, next);   
                visited.add(next);
                stack.push(next);
            } else {
                stack.pop();
            }
        }

        start.setDoor(new EntranceDoor(start));
        end.setDoor(new ExitDoor(end));

        return maze;
    }

    private void addDefaultWalls(Maze maze) {
        for (int i = 0; i < Maze.N; i++) {
            for (int j = 0; j < Maze.M; j++) {
                Room room = maze.getRoom(i, j);
                room.getWalls().clear();
                room.addWall(new Wall('N', true));
                room.addWall(new Wall('S', true));
                room.addWall(new Wall('E', true));
                room.addWall(new Wall('W', true));
            }
        }
    }

    private void removeWallBetween(Room a, Room b) {
        int dx = b.getX() - a.getX();
        int dy = b.getY() - a.getY();

        if (dx == 1) { 
            removeWall(a, 'S');
            removeWall(b, 'N');
        } else if (dx == -1) { 
            removeWall(a, 'N');
            removeWall(b, 'S');
        } else if (dy == 1) { 
            removeWall(a, 'E');
            removeWall(b, 'W');
        } else if (dy == -1) { 
            removeWall(a, 'W');
            removeWall(b, 'E');
        }
    }

    private void removeWall(Room room, char direction) {
        room.getWalls().removeIf(w -> w.getDirection() == direction);
    }

    private List<Room> getUnvisitedNeighbors(Maze maze, Room room, Set<Room> visited) {
        List<Room> neighbors = new ArrayList<>();
        int x = room.getX();
        int y = room.getY();

        if (x > 0 && !visited.contains(maze.getRoom(x - 1, y))) neighbors.add(maze.getRoom(x - 1, y));
        if (x < Maze.N - 1 && !visited.contains(maze.getRoom(x + 1, y))) neighbors.add(maze.getRoom(x + 1, y));
        if (y > 0 && !visited.contains(maze.getRoom(x, y - 1))) neighbors.add(maze.getRoom(x, y - 1));
        if (y < Maze.M - 1 && !visited.contains(maze.getRoom(x, y + 1))) neighbors.add(maze.getRoom(x, y + 1));

        return neighbors;
    }

    private void createInnerDoor(Room from, Room to) {
        from.setDoor(new InnerDoor(from, to));
        to.setDoor(new InnerDoor(to, from));
    }
}
