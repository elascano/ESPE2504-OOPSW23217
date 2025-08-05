/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.composite.abstractfactory.model;

/**
 *
 * @author PC
 */
public class LinuxMenu extends Menu {
    
    @Override
    public void paint() {
        System.out.println("I'm a LinuxMenu: " + caption);
    }
}
