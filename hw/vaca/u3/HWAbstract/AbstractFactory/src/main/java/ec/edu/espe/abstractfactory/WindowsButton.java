/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.abstractfactory;

/**
 *
 * @author Kevin Vaca Edison's OOP ESPE
 */
public class WindowsButton implements Button{

    @Override
    public void paint() {
        System.out.println("Rendering a button in Windows style");
    }   
}
