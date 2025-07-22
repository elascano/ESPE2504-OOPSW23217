/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.view;

import ec.edu.espe.model.Cell;
import ec.edu.espe.model.Maze;

/**
 *
 * @author Michael Chicaiza SOFTCRAF DCCO ESPE
 */
public class MazeConsoleView implements MazeDisplay {
    public void show(Maze maze) {
        Cell[][] cells = maze.getCells();
        int height = maze.getHeight();
        int width = maze.getWidth();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                System.out.print("+");
                System.out.print(cells[y][x].top ? "---" : "   ");
            }
            System.out.println("+");

            for (int x = 0; x < width; x++) {
                System.out.print(cells[y][x].left ? "|" : " ");
                System.out.print("   ");
            }
            System.out.println(cells[y][width - 1].right ? "|" : " ");

            if (y == height - 1) {
                for (int x = 0; x < width; x++) {
                    System.out.print("+");
                    System.out.print(cells[y][x].bottom ? "---" : "   ");
                }
                System.out.println("+");
            }
        }
    }

    public void show(Object maze) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

