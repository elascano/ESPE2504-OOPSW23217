/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.controller;

import ec.edu.espe.model.Maze;
import ec.edu.espe.view.MazeDisplay;

/**
 *
 * @author Michael Chicaiza SOFTCRAF DCCO ESPE
 */
public class MazeController {
    private final Maze maze;
    private final MazeDisplay view;

    public MazeController(int width, int height, MazeDisplay view) {
        this.maze = new Maze(width, height);
        this.view = view;
    }

    public void displayMaze() {
        view.show(maze);
    }
}
