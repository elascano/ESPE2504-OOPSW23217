/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.mazegenerator.model;

/**
 *
 * @author jorge
 */
public class Wall {
    private char direction;
    private boolean exist;

    public Wall(char direction, boolean exists) {
        this.direction = direction;
        this.exist = exists;
    }

    public char getDirection() {
        return direction;
    }

    public boolean exists() {
        return exist;
    }
    
}
