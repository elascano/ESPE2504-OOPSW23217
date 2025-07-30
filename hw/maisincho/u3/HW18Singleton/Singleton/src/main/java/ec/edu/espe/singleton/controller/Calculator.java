package ec.edu.espe.singleton.controller;

import ec.edu.espe.singleton.model.USTax;

/**
 *
 * @author Isaac Maisincho Crafters_Market DCCO ESPE
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
