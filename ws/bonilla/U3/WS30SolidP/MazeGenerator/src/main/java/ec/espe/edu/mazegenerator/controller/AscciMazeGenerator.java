package ec.espe.edu.mazegenerator.controller;

import ec.espe.edu.mazegenerator.model.Maze;

/**
 *
 * @author David Bonilla
 */
public class AscciMazeGenerator implements IMazeGenerator { //interface segregation

    @Override
    public void print(Maze maze) {
        System.out.println("Generating a Maze of size -> " + maze);
    }

}
