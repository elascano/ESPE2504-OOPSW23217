/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.mavenproject1;

/**
 *
 * @author Kevin Vaca Edison's OOP ESPE
 */
public class HotChocolate extends CaffeineBeverage {
   protected void brew() {
        System.out.println("Dissolving cocoa powder in hot water");
    }
    
    @Override
    protected void addCondiments() {
        System.out.println("Adding marshmallows");
    }
    
    @Override
    protected boolean wantsCondiments() {
        // Hot chocolate might not always need condiments
        System.out.println("Would you like marshmallows? (yes/no)");
        return false; // Default to no for this example
    }
}
