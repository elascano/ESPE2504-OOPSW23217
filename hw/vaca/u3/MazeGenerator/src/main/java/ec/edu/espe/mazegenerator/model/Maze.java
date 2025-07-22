package ec.edu.espe.mazegenerator.model;

/**
 *
 * @author Kevin Vaca Edison's OOP ESPE
 */
public class Maze {
    private final int width, height;
    private final MazeRoom[][] grid;

    public Maze(int width, int height) {
        this.width = width;
        this.height = height;
        grid = new MazeRoom[height][width];
        for (int y = 0; y < height; y++)
            for (int x = 0; x < width; x++)
                grid[y][x] = new MazeRoom();
    }
    
    public MazeRoom getRoom(int x, int y) {
        return grid[y][x];
    }

    public int getWidth() { 
        return width; 
    }
    public int getHeight() { 
        return height; 
    }
}
