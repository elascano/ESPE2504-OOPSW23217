
package ec.edu.espe.mazegenerator.model;

import java.util.Random;

/**
 *
 * @author Isaac Maisincho Crafters_Market DCCO ESPE
 */
public class MazeBuilder implements MazeGenerator {
        private final Random random = new Random();

    @Override
    public Maze generate(int width, int height) {
        Room[][] rooms = new Room[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                rooms[x][y] = new Room(x, y);
            }
        }

        Room entrance = rooms[0][0];
        Room exit = rooms[width - 1][height - 1];

        createPath(entrance, exit, rooms, width, height);
        return new Maze(rooms, entrance, exit);
    }

    private void createPath(Room current, Room exit, Room[][] rooms, int width, int height) {
        if (current.equals(exit)) {
            return;
        }

        int x = current.getX();
        int y = current.getY();

        if (x < width - 1) {
            Room right = rooms[x + 1][y];
            Door door = new Door(current, right);
            current.addDoor(door);
            right.addDoor(door);
            createPath(right, exit, rooms, width, height);
        } else if (y < height - 1) {
            Room down = rooms[x][y + 1];
            Door door = new Door(current, down);
            current.addDoor(door);
            down.addDoor(door);
            createPath(down, exit, rooms, width, height);
        }
    }
}
