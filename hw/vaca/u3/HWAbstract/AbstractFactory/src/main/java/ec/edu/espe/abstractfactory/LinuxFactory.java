/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.abstractfactory;

/**
 *
 * @author Kevin Vaca Edison's OOP ESPE
 */
public class LinuxFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new LinuxButton();
    }

    @Override
    public Menu createMenu() {
        return new LinuxMenu();
    }   
}
