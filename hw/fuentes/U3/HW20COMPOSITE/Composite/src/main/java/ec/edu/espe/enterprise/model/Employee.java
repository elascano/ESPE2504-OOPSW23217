/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.enterprise.model;

/**
 *
 * @author jorge
 */
public abstract class Employee {
    String name="not assignet yet";
    String title = "not assignet yet";
    
    public void stateName(){
        System.out.println(title + " " + name);
    }
    
    
}
