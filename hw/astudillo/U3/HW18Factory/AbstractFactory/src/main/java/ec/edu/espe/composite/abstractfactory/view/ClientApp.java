/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.composite.abstractfactory.view;

import ec.edu.espe.composite.abstractfactory.controller.GUIFactory;
import ec.edu.espe.composite.abstractfactory.model.Button;
import ec.edu.espe.composite.abstractfactory.model.Menu;

/**
 *
 * @author PC
 */
public class ClientApp {
    
    public static void main(String[] args) {
        GUIFactory aFactory = GUIFactory.getFactory();
        
        Button aButton = aFactory.createButton();
        aButton.caption = "Play";
        aButton.paint();
        
        Menu aMenu = aFactory.createMenu();
        aMenu.caption = "File";
        aMenu.paint();
    }
}
