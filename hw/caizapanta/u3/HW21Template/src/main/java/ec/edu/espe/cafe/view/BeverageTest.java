package ec.edu.espe.cafe.view;
import ec.edu.espe.cafe.model.Coffee;
import ec.edu.espe.cafe.model.Tea;

/**
 * 
 * @author Tammy Caizapanta
 */

public class BeverageTest {

    public static void main(String[] args) {
        Coffee coffee = new Coffee();
        Tea tea = new Tea();
        
        System.out.println("Making tea: \n");
        tea.prepareRecipe();
        System.out.println("Tea ready");
        
        System.out.println("\nMaking coffee: \n");
        coffee.prepareRecipe();
        System.out.println("Coffee ready");

    }
}
