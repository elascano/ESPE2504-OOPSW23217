/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espe.cafe.view;

import ec.edu.espe.cafe.model.Coffee;
import ec.edu.espe.cafe.model.Tea;

/**
 *
 * @author jorge
 */
public class BeverageTest {

    public static void main(String[] args) {
        Tea tea = new Tea();
        Coffee coffee = new Coffee();
        
        System.out.println("\nMaking tea...");
        tea.prepareRecipe();
        
        System.out.println("\nMaking coffee...");
        coffee.prepareRecipe();
    }
}
