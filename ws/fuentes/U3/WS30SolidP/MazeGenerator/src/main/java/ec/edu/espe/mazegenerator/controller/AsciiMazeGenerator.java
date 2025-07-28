package ec.edu.espe.mazegenerator.controller;

import ec.edu.espe.mazegenerator.model.Maze;

/**
 *
 * @author jorge
 */
public class AsciiMazeGenerator implements IMazeGenerator{ //Interface segregation

    @Override
    public void print() {
        System.out.println("generatng a maze of size ----> ");
    }

    
}
