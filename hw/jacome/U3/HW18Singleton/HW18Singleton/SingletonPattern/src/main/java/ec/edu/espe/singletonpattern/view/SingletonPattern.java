package ec.edu.espe.singletonpattern.view;

import ec.edu.espe.singletonpattern.controller.Calculator;
import ec.edu.espe.singletonpattern.model.USTax;

/**
 *
 * @author Micaela Jacome DESKTOP-46VMNHU ESPE
 */
public class SingletonPattern {

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
