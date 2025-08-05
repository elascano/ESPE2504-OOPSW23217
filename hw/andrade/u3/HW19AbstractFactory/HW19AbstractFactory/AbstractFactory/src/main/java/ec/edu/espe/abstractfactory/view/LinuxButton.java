/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.abstractfactory.view;

import ec.edu.espe.abstractfactory.model.Button;

/**
 *
 * @author Micaela Jácome
 */
public class LinuxButton extends Button{

    @Override
    public void paint() {
        System.out.println("I'm a Linux Button: " + caption);
    }
}
