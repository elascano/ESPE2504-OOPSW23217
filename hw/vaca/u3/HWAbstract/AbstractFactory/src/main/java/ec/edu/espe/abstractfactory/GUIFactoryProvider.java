/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.abstractfactory;

/**
 *
 * @author Kevin Vaca Edison's OOP ESPE
 */
public class GUIFactoryProvider {
        public static GUIFactory getFactory() {
        String osName = System.getProperty("os.name").toLowerCase();
        
        if (osName.contains("win")) {
            return new WindowsFactory();
        } else if (osName.contains("nix") || osName.contains("nux")) {
            return new LinuxFactory();
        }
        
        throw new UnsupportedOperationException("OS not supported: " + osName);
    }
}
