package maze;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MazeGenerator {
    private final int rows;
    private final int cols;
    private final int[][] grid;
    
    public MazeGenerator(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.grid = generateMaze();
    }
    
    private int[][] generateMaze() {
        // Initialize grid with walls (1 = wall, 0 = path)
        int[][] maze = new int[2 * rows + 1][2 * cols + 1];
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                maze[i][j] = 1;
            }
        }
        
        boolean[][] visited = new boolean[rows][cols];
        Random rand = new Random();
        int startRow = rand.nextInt(rows);
        int startCol = rand.nextInt(cols);
        
        List<int[]> stack = new ArrayList<>();
        stack.add(new int[]{startRow, startCol});
        visited[startRow][startCol] = true;
        
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // Up, Right, Down, Left
        
        while (!stack.isEmpty()) {
            int[] current = stack.get(stack.size() - 1);
            List<int[]> neighbors = new ArrayList<>();
            
            for (int[] dir : directions) {
                int newRow = current[0] + dir[0];
                int newCol = current[1] + dir[1];
                
                if (newRow >= 0 && newRow < rows && 
                    newCol >= 0 && newCol < cols && 
                    !visited[newRow][newCol]) {
                    neighbors.add(new int[]{dir[0], dir[1], newRow, newCol});
                }
            }
            
            if (!neighbors.isEmpty()) {
                int[] chosen = neighbors.get(rand.nextInt(neighbors.size()));
                maze[2 * current[0] + 1 + chosen[0]][2 * current[1] + 1 + chosen[1]] = 0;
                visited[chosen[2]][chosen[3]] = true;
                stack.add(new int[]{chosen[2], chosen[3]});
            } else {
                stack.remove(stack.size() - 1);
            }
        }
        
        // Set entrance and exit
        maze[1][0] = 2;       // Entrance (marked with 2)
        maze[2 * rows - 1][2 * cols] = 3;  // Exit (marked with 3)
        
        return maze;
    }
    
    public void printMaze() {
        // Display characters
        final char WALL = '█';
        final char PATH = ' ';
        final char ENTRANCE = 'E';
        final char EXIT = 'X';
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                char displayChar;
                switch (grid[i][j]) {
                    case 0:
                        displayChar = PATH;
                        break;
                    case 2:
                        displayChar = ENTRANCE;
                        break;
                    case 3:
                        displayChar = EXIT;
                        break;
                    default:
                        displayChar = WALL;
                }
                System.out.print(displayChar);
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("MAZE GENERATOR");
        System.out.println("--------------");
        
        try {
            // Get user input
            System.out.print("Enter number of rows (minimum 2): ");
            int rows = scanner.nextInt();
            System.out.print("Enter number of columns (minimum 2): ");
            int cols = scanner.nextInt();
            
            if (rows < 2 || cols < 2) {
                System.out.println("Error: Maze must be at least 2x2");
                return;
            }
            
            // Generate and display maze
            MazeGenerator generator = new MazeGenerator(rows, cols);
            System.out.println("\nGenerated Maze:");
            generator.printMaze();
            
            // Print legend
            System.out.println("\nLegend:");
            System.out.println("█ = Wall");
            System.out.println("E = Entrance");
            System.out.println("X = Exit");
            
        } catch (Exception e) {
            System.out.println("Error: Invalid input. Please enter numbers only.");
        } finally {
            scanner.close();
        }
    }
}