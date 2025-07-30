package ec.edu.espe.singleton.view;

import ec.edu.espe.singleton.controller.Calculator;
import ec.edu.espe.singleton.model.USTax;

/**
 *
 * @author Isaac Maisincho Crafters_Market DCCO ESPE
 */
public class Singleton {

    public static void main(String[] args) {
        Calculator calculator = new Calculator(); 

        float subtotal = 10.0F;
        float total = calculator.salesTotal(subtotal);
        System.out.println("The total is --> $" + total);

        USTax.getInstance().setTaxPercentage(0.15F);
        total = calculator.salesTotal(subtotal);
        System.out.println("The total with 15% tax is --> $" + total);
    }
}
