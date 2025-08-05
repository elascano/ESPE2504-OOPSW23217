package ec.edu.espe.templatemethod.controller;

import ec.edu.espe.templatemethod.model.Coffee;
import ec.edu.espe.templatemethod.model.Tea;

/**
 *
 * @author Bonilla David SoftCrafters
 */
public class BeverageTest {

    public static void main(String[] args) {
        Tea tea = new Tea();
        Coffee coffee = new Coffee();
        System.out.println("\nMaking tea .."); 
        tea.prepareRecipe();
        System.out.println("\nMaking coffee ...");
        coffee.prepareRecipe();
    }
}
