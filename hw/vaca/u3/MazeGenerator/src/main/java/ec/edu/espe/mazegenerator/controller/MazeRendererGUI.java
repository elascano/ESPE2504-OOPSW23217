package ec.edu.espe.mazegenerator.controller;

import ec.edu.espe.mazegenerator.model.Maze;
import ec.edu.espe.mazegenerator.model.MazeRoom;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Kevin Vaca Edison's OOP ESPE
 */
public class MazeRendererGUI extends JPanel implements MazeRenderer {
    private Maze maze;
    private static final int CELL_SIZE = 30;

    @Override
    public void render(Maze maze) {
        this.maze = maze;
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Maze Renderer (GUI)");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize((maze.getWidth() + 1) * CELL_SIZE, (maze.getHeight() + 2) * CELL_SIZE);
            frame.add(this);
            frame.setLocationRelativeTo(null); // Center window
            frame.setVisible(true);
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (maze == null) return;

        for (int y = 0; y < maze.getHeight(); y++) {
            for (int x = 0; x < maze.getWidth(); x++) {
                int x1 = x * CELL_SIZE;
                int y1 = y * CELL_SIZE;

                MazeRoom room = maze.getRoom(x, y);

                // Set color for walls
                g.setColor(Color.BLACK);

                // Top wall
                if (!room.isOpen(MazeRoom.Direction.NORTH))
                    g.drawLine(x1, y1, x1 + CELL_SIZE, y1);
                // Left wall
                if (!room.isOpen(MazeRoom.Direction.WEST))
                    g.drawLine(x1, y1, x1, y1 + CELL_SIZE);
                // Bottom wall
                if (!room.isOpen(MazeRoom.Direction.SOUTH))
                    g.drawLine(x1, y1 + CELL_SIZE, x1 + CELL_SIZE, y1 + CELL_SIZE);
                // Right wall
                if (!room.isOpen(MazeRoom.Direction.EAST))
                    g.drawLine(x1 + CELL_SIZE, y1, x1 + CELL_SIZE, y1 + CELL_SIZE);

                // Draw Start and Exit
                if (x == 0 && y == 0) {
                    g.setColor(Color.GREEN);
                    g.fillRect(x1 + 5, y1 + 5, CELL_SIZE - 10, CELL_SIZE - 10);
                } else if (x == maze.getWidth() - 1 && y == maze.getHeight() - 1) {
                    g.setColor(Color.RED);
                    g.fillRect(x1 + 5, y1 + 5, CELL_SIZE - 10, CELL_SIZE - 10);
                }
            }
        }
    }
}
