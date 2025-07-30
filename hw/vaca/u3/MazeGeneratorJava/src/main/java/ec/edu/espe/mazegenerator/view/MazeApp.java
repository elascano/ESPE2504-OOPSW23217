package ec.edu.espe.mazegenerator.view;

import ec.edu.espe.mazegenerator.controller.DFSMazeGenerator;
import ec.edu.espe.mazegenerator.controller.MazeGenerator;
import ec.edu.espe.mazegenerator.controller.MazeRenderer;
import ec.edu.espe.mazegenerator.controller.MazeRendererASCII;
import ec.edu.espe.mazegenerator.controller.MazeRendererGUI;
import ec.edu.espe.mazegenerator.model.Maze;

/**
 *
 * @author Kevin Vaca Edison's OOP ESPE
 */
public class MazeApp {

public static void main(String[] args) {
        int width = 5;
        int height = 5;

        MazeGenerator generator = new DFSMazeGenerator();
        MazeRenderer renderer = new MazeRendererGUI();

        Maze maze = generator.generate(width, height);
        renderer.render(maze);
    }
}