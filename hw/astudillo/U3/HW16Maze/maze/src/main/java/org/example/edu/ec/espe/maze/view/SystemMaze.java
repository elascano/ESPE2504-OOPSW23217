package org.example.edu.ec.espe.maze.view;

import org.example.edu.ec.espe.maze.controller.*;
import java.util.Scanner;

public class SystemMaze {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el número de columnas del laberinto: ");
        int numberOfColumns = scanner.nextInt();
        System.out.print("Ingrese el número de filas del laberinto: ");
        int numberOfRows = scanner.nextInt();
        scanner.close();

        SettingMaze mazeSetting = new SettingMaze(numberOfRows, numberOfColumns) {};
        Maze maze = mazeSetting.generateMaze();
        maze.display();
    }
}
