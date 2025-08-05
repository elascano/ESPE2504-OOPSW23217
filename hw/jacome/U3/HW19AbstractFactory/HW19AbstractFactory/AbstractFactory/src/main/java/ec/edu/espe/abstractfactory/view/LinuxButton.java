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
<<<<<<< HEAD
        System.out.println("I'm a Linux Button: " + caption);
=======
        System.out.println("I'm a LinuxButton :" + caption);
        System.out.println("------------");
        System.out.println("| " + String.format("%-11s", caption) + " |");
        System.out.println("------------");
        
>>>>>>> a5c09eb1b75f87dfbf3710064cf31fb403b4b7ba
    }
}
