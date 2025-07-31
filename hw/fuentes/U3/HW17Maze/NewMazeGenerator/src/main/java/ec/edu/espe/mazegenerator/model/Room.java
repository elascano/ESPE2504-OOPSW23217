/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.mazegenerator.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jorge
 */
public class Room {
    private int x;
    private int y;
    private List<Wall> walls;
    private Door door;

    public Room(int x, int y) {
        this.x = x;
        this.y = y;
        this.walls = new ArrayList<>();
    }

    public boolean hasWall(char direction) {
        return walls.stream().anyMatch(w -> w.getDirection() == direction && w.exists());
    }

    public boolean hasDoor() {
        return door != null;
    }

    public boolean isCorner() {
        return (x == 0 || x == Maze.N - 1) && (y == 0 || y == Maze.M - 1);
    }

    public void setDoor(Door door) {
        this.door = door;
    }

    public List<Wall> getWalls() {
        return walls;
    }

    public Door getDoor() {
        return door;
    }

    public int getX(){ 
        return x; 
    }
    public int getY(){ 
        return y; 
    }
    
    public void addWall(Wall wall) {
    if (walls.size() < 4) {
        walls.add(wall);
    }
}
    
}
