/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.mazegenerator.model;

/**
 *
 * @author jorge
 */
public abstract class Door {
    protected Room from;
    protected Room to;

    public Door(Room from, Room to) {
        this.from = from;
        this.to = to;
    }

    public abstract String getType();
    public abstract boolean isExterior();

    public Room getFrom(){ 
        return from; 
    }
    public Room getTo(){ 
        return to; 
    }
    
}
