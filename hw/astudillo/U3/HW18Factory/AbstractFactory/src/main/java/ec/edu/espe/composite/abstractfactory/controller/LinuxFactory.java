/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.composite.abstractfactory.controller;

import ec.edu.espe.composite.abstractfactory.model.Button;
import ec.edu.espe.composite.abstractfactory.model.Menu;
import ec.edu.espe.composite.abstractfactory.view.LinuxButton;
import ec.edu.espe.composite.abstractfactory.model.LinuxMenu;

/**
 *
 * @author PC
 */
public class LinuxFactory extends GUIFactory {
    
    @Override
    public Button createButton() {
        return new LinuxButton();
    }
    
    @Override
    public Menu createMenu() {
        return new LinuxMenu();
    }
}
