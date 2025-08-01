/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.mavenproject1;

/**
 *
 * @author Kevin Vaca Edison's OOP ESPE
 */
public class Tea extends CaffeineBeverage {
    @Override
    protected void brew() {
        System.out.println("Steeping the tea");
    }
    
    @Override
    protected void addCondiments() {
        System.out.println("Adding lemon");
    }
    
    @Override
    protected boolean wantsCondiments() {
        // Example of overriding the hook method
        System.out.println("Would you like lemon with your tea? (yes/no)");
        // In a real app, you'd get user input here
        return true; // Default to yes for this example
    }
}
