/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.composite.abstractfactory.view;

import ec.edu.espe.composite.abstractfactory.model.Button;

/**
 *
 * @author PC
 */
public class LinuxButton extends Button {
    
    @Override
    public void paint() {
        System.out.println("I'm a LinuxButton: " + caption);
    }
}
