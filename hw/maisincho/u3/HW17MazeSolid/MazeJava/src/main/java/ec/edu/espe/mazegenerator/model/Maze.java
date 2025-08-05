/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.mazegenerator.model;

/**
 *
 * @author Isaac Maisincho Crafters_Market DCCO ESPE
 */
public class Maze {

    private final Room[][] rooms;
    private final Room entrance;
    private final Room exit;

    public Maze(Room[][] rooms, Room entrance, Room exit) {
        this.rooms = rooms;
        this.entrance = entrance;
        this.exit = exit;
    }

    public Room[][] getRooms() {
        return rooms;
    }

    public Room getEntrance() {
        return entrance;
    }

    public Room getExit() {
        return exit;
    }
}
