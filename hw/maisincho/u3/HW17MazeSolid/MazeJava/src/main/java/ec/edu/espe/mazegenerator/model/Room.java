/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.mazegenerator.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Isaac Maisincho Crafters_Market DCCO ESPE
 */
public class Room {

    private final int x;
    private final int y;
    private final List<Door> doors;

    public Room(int x, int y) {
        this.x = x;
        this.y = y;
        this.doors = new ArrayList<>();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public List<Door> getDoors() {
        return doors;
    }

    public void addDoor(Door door) {
        doors.add(door);
    }
}
