package ec.edu.espe.controller;

import ec.edu.espe.model.MazeModel;
import java.util.Random;
import java.util.Stack;
/**
 *
 * @author Carlos Paillacho
 */
public class DFSMazeGenerator implements MazeGenerator {
    @Override
    public MazeModel generate(int width, int height) {
        MazeModel maze = new MazeModel(width, height);
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                maze.setRoom(x, y, new Room(x, y));
            }
        }
        Stack<Room> stack = new Stack<>();
        Room start = maze.getRoom(0, 0);
        stack.push(start);
        Random rand = new Random();

        while (!stack.isEmpty()) {
            Room current = stack.peek();

            Room neighbor = /* ... */ null;
            if (neighbor != null) {

            } else {
                stack.pop();
            }
        }

        maze.setEntrance(new Entrance(maze.getRoom(0, 0)));
        maze.setExit(new Exit(maze.getRoom(width - 1, height - 1)));

        return maze;
    }
}