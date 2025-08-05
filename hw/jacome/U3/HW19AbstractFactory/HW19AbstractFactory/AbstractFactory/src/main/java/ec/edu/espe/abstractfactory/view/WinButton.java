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
        
        
>>>>>>> a5c09eb1b75f87dfbf3710064cf31fb403b4b7ba
    }
}
