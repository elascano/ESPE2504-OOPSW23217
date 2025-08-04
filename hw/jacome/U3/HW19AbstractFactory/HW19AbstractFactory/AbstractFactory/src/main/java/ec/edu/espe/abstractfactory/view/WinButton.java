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
public class WinButton extends Button{

    @Override
    public void paint() {
        System.out.println("I'm a WinButton :" + caption);
<<<<<<< HEAD
=======
        System.out.println("------------");
        System.out.println("| " + String.format("%-11s", caption) + " |");
        System.out.println("------------");
        
        
>>>>>>> 1e4c7996c2a22e02abbfff4a34b99d02ef14e579
    }
}
