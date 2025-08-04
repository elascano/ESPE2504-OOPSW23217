package ec.edu.espe.view;
import ec.edu.espe.model.USTax;

/**
 *
 * @author Bernardo
 */

public class Calculator { //add "public" and capitalize class name
    public static void main(String[] args) {
        USTax tax = USTax.getInstance();

        float basePrice = 100.00f;
        float total = tax.salesTotal(basePrice);

        System.out.println("Base price --> $" + basePrice);
        System.out.println("Tax Rate --> " + tax.getTaxRate() * 100 + "%");
        System.out.println("Total price --> $" + total);
    }
}
