package ec.edu.espe.mazegenerator.controller;
import ec.edu.espe.mazegenerator.model.Maze;
/**
 *
 * @author Kevin Vaca Edison's OOP ESPE
 */
public interface MazeGenerator {
    Maze generate(int width, int height);
}
