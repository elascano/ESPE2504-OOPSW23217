

package ec.edu.espe.template.view;

import ec.edu.espe.template.model.Coffee;
import ec.edu.espe.template.model.Tea;

/**
 *
 * @author Isaac Maisincho Crafters_Market DCCO ESPE
 */
public class BeverageTest {

    public static void main(String[] args) {
        Tea tea=new Tea();
        Coffee coffe=new Coffee();
        
        System.out.println("Tea..");
        tea.prepareRecipe();
        System.out.println("Coffe..");
        coffe.prepareRecipe();
    }
}
