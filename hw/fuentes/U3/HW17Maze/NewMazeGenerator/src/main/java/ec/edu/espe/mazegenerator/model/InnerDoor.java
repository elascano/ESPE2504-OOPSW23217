/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.mazegenerator.model;

/**
 *
 * @author jorge
 */
public class InnerDoor extends Door{
    public InnerDoor(Room from, Room to) {
        super(from, to);
    }

    @Override
    public String getType() {
        return "Inner";
    }

    @Override
    public boolean isExterior() {
        return false;
    }
    
}
