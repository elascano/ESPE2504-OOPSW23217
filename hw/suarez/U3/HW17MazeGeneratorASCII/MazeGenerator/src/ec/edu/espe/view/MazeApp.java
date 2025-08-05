package ec.edu.espe.view;

import ec.edu.espe.controller.MazeController;
import ec.edu.espe.model.Maze;

import javax.swing.*;
import java.util.Scanner;

public class MazeApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MazeController controller = new MazeController();

        System.out.println("=== Maze Generator ===");

        System.out.print("Enter maze height (rows): ");
        int rows = scanner.nextInt();

        System.out.print("Enter maze width (columns): ");
        int cols = scanner.nextInt();

        if (rows < 2 || cols < 2) {
            System.out.println("Maze dimensions must be at least 2x2.");
            return;
        }

        controller.createMaze(rows, cols);
        System.out.println("\nGenerated Maze:\n");
        controller.printMazeAscii();

        /* show GUI with maze
        Maze maze = controller.getMaze();
        SwingUtilities.invokeLater(() -> {
            MazeGUI gui = new MazeGUI(maze);
            gui.setVisible(true);
        });*/

        scanner.close();
    }
}
