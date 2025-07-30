/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ec.edu.espe.mazegenerator.view;

import ec.edu.espe.mazegenerator.controller.AsciiMazePrinter;
import ec.edu.espe.mazegenerator.controller.MazePrinter;
import ec.edu.espe.mazegenerator.model.Maze;
import ec.edu.espe.mazegenerator.model.MazeBuilder;
import ec.edu.espe.mazegenerator.model.MazeGenerator;

/**
 *
 * @author Isaac Maisincho Crafters_Market DCCO ESPE
 */
public class FrmMaze {
    public static void main(String[] args) {

        int width = 5;
        int height = 5;

        MazeGenerator generator = new MazeBuilder();
        Maze maze = generator.generate(width, height);

        MazePrinter printer = new AsciiMazePrinter();
        printer.print(maze);
    }

}
