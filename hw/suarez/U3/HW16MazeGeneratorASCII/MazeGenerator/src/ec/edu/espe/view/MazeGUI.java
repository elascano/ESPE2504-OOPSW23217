package ec.edu.espe.view;

import ec.edu.espe.model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class MazeGUI extends JFrame {
    private Maze maze;

    public MazeGUI(Maze maze) {
        this.maze = maze;
        setTitle("Maze Viewer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        int scale = 40;
        BufferedImage mazeImage = createMazeImage(maze, scale);
        JLabel label = new JLabel(new ImageIcon(mazeImage));
        add(label);
        pack();
        setLocationRelativeTo(null); // Center the window
    }

    public static BufferedImage createMazeImage(Maze maze, int scale) {
        int rows = maze.getCols();
        int cols = maze.getRows();

        int width = cols * scale;
        int height = rows * scale;

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();

        // Background
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);

        // Walls
        g.setColor(Color.BLACK);
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                Room room = maze.getRoom(row, col);
                int x = col * scale;
                int y = row * scale;

                if (room.getWall(Direction.NORTH) != null && !room.getWall(Direction.NORTH).isOpen())
                    g.drawLine(x, y, x + scale, y);
                if (room.getWall(Direction.WEST) != null && !room.getWall(Direction.WEST).isOpen())
                    g.drawLine(x, y, x, y + scale);
                if (room.getWall(Direction.EAST) != null && !room.getWall(Direction.EAST).isOpen())
                    g.drawLine(x + scale, y, x + scale, y + scale);
                if (room.getWall(Direction.SOUTH) != null && !room.getWall(Direction.SOUTH).isOpen())
                    g.drawLine(x, y + scale, x + scale, y + scale);
            }
        }

        g.dispose();
        return image;
    }
}
