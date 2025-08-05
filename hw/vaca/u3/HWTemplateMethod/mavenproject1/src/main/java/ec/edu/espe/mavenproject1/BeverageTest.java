/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.mavenproject1;

/**
 *
 * @author Kevin Vaca Edison's OOP ESPE
 */
public class BeverageTest {
    public static void main(String[] args) {
        System.out.println("Preparing Tea:");
        CaffeineBeverage tea = new Tea();
        tea.prepareRecipe();
        
        System.out.println("\nPreparing Coffee:");
        CaffeineBeverage coffee = new Coffee();
        coffee.prepareRecipe();
        
        System.out.println("\nPreparing Hot Chocolate:");
        CaffeineBeverage hotChocolate = new HotChocolate();
        hotChocolate.prepareRecipe();
    }
}
