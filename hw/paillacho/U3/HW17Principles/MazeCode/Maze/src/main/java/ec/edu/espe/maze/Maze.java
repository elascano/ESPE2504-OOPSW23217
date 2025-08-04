package ec.edu.espe.maze;

import ec.edu.espe.controller.DFSMazeGenerator;
import ec.edu.espe.controller.MazeGenerator;
import ec.edu.espe.model.MazeModel;
import ec.edu.espe.view.MazeASCIIPrinter;
import ec.edu.espe.view.MazeRenderer;

import java.util.Scanner;
//Author: Carlos Paillacho
public class Maze {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter maze width: ");
        int width = scanner.nextInt();

        System.out.print("Enter maze height: ");
        int height = scanner.nextInt();

        // Usamos el generador DFS existente
        MazeGenerator generator = new DFSMazeGenerator();
        MazeModel model = generator.generate(width, height);

        // Usamos el impresor ASCII existente
        MazeRenderer printer = new MazeASCIIPrinter();
        printer.render(model);

        scanner.close();
    }
}
