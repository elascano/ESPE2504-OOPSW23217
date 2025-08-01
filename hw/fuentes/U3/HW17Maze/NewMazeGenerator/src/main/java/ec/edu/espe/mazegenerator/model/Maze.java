/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.mazegenerator.model;

/**
 *
 * @author jorge
 */
public class Maze {
    public static int N;
    public static int M;
    private Room[][] rooms;
    private Room entrance;
    private Room exit;

    public Maze(int N, int M) {
        Maze.N = N;
        Maze.M = M;
        this.rooms = new Room[N][M];
        initializeRooms();
    }

    private void initializeRooms() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                rooms[i][j] = new Room(i, j);
            }
        }
    }

    public Room getRoom(int x, int y) {
        if (x >= 0 && x < N && y >= 0 && y < M) {
            return rooms[x][y];
        }
        return null;
    }

    public Room[][] getRooms() {
        return rooms;
    }

    public void setEntrance(Room entrance) {
        this.entrance = entrance;
    }

    public Room getEntrance() {
        return entrance;
    }

    public void setExit(Room exit) {
        this.exit = exit;
    }

    public Room getExit() {
        return exit;
    }

    public String toAscii() {
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append("[ ]");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
    
}
