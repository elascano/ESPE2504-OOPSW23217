/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.client.model;

/**
 *
 * @author jorge
 */
public abstract class GUIFactory {
    public static GUIFactory getFactory(){
        int sys = readFromConfigFile("OS_TYPE");
        if(sys==0)
            return(new WinFactory());
        else
            return(new LinuxFactory());
    }
    
    private static int readFromConfigFile(String key) {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            return 0;
        } else {
            return 1;
        }

    }
    
    public abstract Button createButton();
    public abstract Menu createeMenu();
    
}
