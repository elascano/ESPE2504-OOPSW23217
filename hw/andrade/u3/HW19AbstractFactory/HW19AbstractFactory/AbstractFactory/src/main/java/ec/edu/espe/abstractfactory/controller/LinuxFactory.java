/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.abstractfactory.controller;

import ec.edu.espe.abstractfactory.model.Button;
import ec.edu.espe.abstractfactory.model.LinuxMenu;
import ec.edu.espe.abstractfactory.model.Menu;
import ec.edu.espe.abstractfactory.view.LinuxButton;

/**
 *
 * @author Julio Andrade
 */
public class LinuxFactory extends GUIFactory{

    @Override
    public Button createButton() {
        return (new LinuxButton());
    }

    @Override
    public Menu createMenu() {
        return (new LinuxMenu());
    }
}
