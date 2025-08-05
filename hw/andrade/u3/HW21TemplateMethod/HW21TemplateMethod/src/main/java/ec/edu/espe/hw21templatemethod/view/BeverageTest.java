package ec.edu.espe.hw21templatemethod.view;

import ec.edu.espe.hw21templatemethod.model.Coffee;
import ec.edu.espe.hw21templatemethod.model.Tea;

/**
 *
 * @author Micaela Jacome DESKTOP-46VMNHU ESPE
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
