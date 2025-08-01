/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.mazegenerator.model;

/**
 *
 * @author jorge
 */
public class EntranceDoor extends Door{
    public EntranceDoor(Room room) {
        super(null, room);
    }

    @Override
    public String getType() {
        return "Entrance";
    }

    @Override
    public boolean isExterior() {
        return true;
    }
    
}
