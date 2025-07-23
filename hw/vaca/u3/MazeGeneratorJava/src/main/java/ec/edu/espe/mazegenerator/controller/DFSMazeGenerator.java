package ec.edu.espe.mazegenerator.controller;

import ec.edu.espe.mazegenerator.model.Maze;
import ec.edu.espe.mazegenerator.model.MazeRoom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Kevin Vaca Edison's OOP ESPE
 */
public class DFSMazeGenerator implements MazeGenerator{

    @Override
    public Maze generate(int width, int height) {
        Maze maze = new Maze(width, height);
        boolean[][] visited = new boolean[height][width];
        dfs(0, 0, maze, visited);
        return maze; 
    }

    private void dfs(int x, int y, Maze maze, boolean[][] visited) {
        visited[y][x] = true;

        List<MazeRoom.Direction> directions = new ArrayList<>(List.of(MazeRoom.Direction.values()));
        Collections.shuffle(directions);

        for (MazeRoom.Direction dir : directions) {
            int nx = x, ny = y;

            switch (dir) {
                case NORTH: ny--; break;
                case SOUTH: ny++; break;
                case EAST: nx++; break;
                case WEST: nx--; break;
            }
            
            if (nx >= 0 && ny >= 0 && ny < maze.getHeight() && nx < maze.getWidth() && !visited[ny][nx]) {
                maze.getRoom(x, y).openWall(dir);
                maze.getRoom(nx, ny).openWall(opposite(dir));
                dfs(nx, ny, maze, visited);
            }
        }
    }

    private MazeRoom.Direction opposite(MazeRoom.Direction dir) {
        return switch (dir) {
            case NORTH -> MazeRoom.Direction.SOUTH;
            case SOUTH -> MazeRoom.Direction.NORTH;
            case EAST  -> MazeRoom.Direction.WEST;
            case WEST  -> MazeRoom.Direction.EAST;
        };
    }
}
