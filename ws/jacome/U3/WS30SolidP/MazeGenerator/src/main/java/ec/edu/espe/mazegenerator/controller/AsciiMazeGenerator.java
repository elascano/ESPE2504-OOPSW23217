package ec.edu.espe.mazegenerator.controller;
import ec.edu.espe.mazegenerator.model.Maze;
/**
 *
 * @author LABS-ESPE
 */
public class AsciiMazeGenerator implements IMazeGenerator {


    public void print(Maze maze) {
        System.out.println("Generating a maze of size -->" + maze);
    }
}
