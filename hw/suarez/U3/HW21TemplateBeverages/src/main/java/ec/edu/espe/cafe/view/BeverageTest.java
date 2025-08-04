package ec.edu.espe.cafe.view;
import ec.edu.espe.cafe.model.Coffee;
import ec.edu.espe.cafe.model.Tea;

/**
 * @author bernardo
 */

public class BeverageTest {

    public static void main(String[] args) {
        Coffee coffee = new Coffee();
        Tea tea = new Tea();
        
        System.out.println("~ MAKING TEA --> \n");
        tea.prepareRecipe();
        System.out.println("Enjoy your tea");
        
        System.out.println("\n~ MAKING COFFEE ---> \n");
        coffee.prepareRecipe();
        System.out.println("Enjoy your coffee");

    }
}
