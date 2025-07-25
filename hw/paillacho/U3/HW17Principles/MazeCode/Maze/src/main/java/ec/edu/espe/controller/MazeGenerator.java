package ec.edu.espe.controller;

import ec.edu.espe.model.MazeModel;
/**
 *
 * @author Carlos Paillacho
 */
public interface MazeGenerator {
    MazeModel generate(int rows, int cols);
}