/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.composite.abstractfactory.controller;

import ec.edu.espe.composite.abstractfactory.model.Button;
import ec.edu.espe.composite.abstractfactory.model.Menu;

/**
 *
 * @author PC
 */
public abstract class GUIFactory {
    
    public static GUIFactory getFactory() {
        int sys = readFromConfigFile("OS_TYPE");
        if (sys == 0) {
            return new WinFactory();
        } else {
            return new LinuxFactory();
        }
    }
    
    private static int readFromConfigFile(String key) {
        // Simplified config reading - returns 0 for Windows, 1 for Linux
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            return 0;
        } else {
            return 1;
        }
    }
    
    public abstract Button createButton();
    public abstract Menu createMenu();
}
