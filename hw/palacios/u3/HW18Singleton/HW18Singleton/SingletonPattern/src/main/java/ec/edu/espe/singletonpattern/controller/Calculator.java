
 */
package ec.edu.espe.singletonpattern.controller;

import ec.edu.espe.singletonpattern.model.USTax;

/**
 *
 * @author Palacios Daniel
 */
public class Calculator {

    public float salesTotal(float subtotal) {
        float total;
        float tax;
        tax = subtotal * USTax.getInstance().getTaxPercentage();
        total = subtotal + tax;
        return total;
    }
}
