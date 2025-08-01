/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.abstractfactory;

/**
 *
 * @author Kevin Vaca Edison's OOP ESPE
 */
public class ClientApp {
        public static void main(String[] args) {
        GUIFactory factory = GUIFactoryProvider.getFactory();
        
        Button button = factory.createButton();
        Menu menu = factory.createMenu();
        
        button.paint();
        menu.paint();
        
        System.out.println("Application running on " + System.getProperty("os.name"));
    }
}
