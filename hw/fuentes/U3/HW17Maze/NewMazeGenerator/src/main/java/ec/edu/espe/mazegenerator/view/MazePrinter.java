/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.mazegenerator.view;

import ec.edu.espe.mazegenerator.model.EntranceDoor;
import ec.edu.espe.mazegenerator.model.ExitDoor;
import ec.edu.espe.mazegenerator.model.Maze;
import ec.edu.espe.mazegenerator.model.Room;

/**
 *
 * @author jorge
 */
public class MazePrinter {
    public static void printMazeAscii(Maze maze) {
        Room[][] rooms = maze.getRooms();
        int N = Maze.N;
        int M = Maze.M;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Room room = rooms[i][j];
                if (hasWall(room, 'N')) {
                    System.out.print("+---");
                } else {
                    System.out.print("+   ");
                }
            }
            System.out.println("+");

            for (int j = 0; j < M; j++) {
                Room room = rooms[i][j];
                if (hasWall(room, 'W')) {
                    System.out.print("|");
                } else {
                    System.out.print(" ");
                }

                if (room.getDoor() instanceof EntranceDoor) {
                    System.out.print(" E ");
                } else if (room.getDoor() instanceof ExitDoor) {
                    System.out.print(" X ");
                } else {
                    System.out.print("   ");
                }
            }

            System.out.println("|");
        }

        for (int j = 0; j < M; j++) {
            if (hasWall(rooms[N - 1][j], 'S')) {
                System.out.print("+---");
            } else {
                System.out.print("+   ");
            }
        }
        System.out.println("+");
    }

    public static boolean hasWall(Room room, char direction) {
        return room.hasWall(direction);
    }
    
}
