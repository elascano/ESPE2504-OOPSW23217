/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.mavenproject1;

/**
 *
 * @author Kevin Vaca Edison's OOP ESPE
 */
public class Coffee extends CaffeineBeverage {
    protected void brew() {
        System.out.println("Dripping coffee through filter");
    }
    
    protected void addCondiments() {
        System.out.println("Adding sugar and milk");
    }
}
