package ec.edu.espe.singleton.controller;

import ec.edu.espe.singleton.model.USTax;
/**
 * 
 * @author David Bonilla SoftCrafters ESPE
 */
public class Calculator {
    
    public static void calculateTax(double sale) {
        USTax tax = USTax.getInstance();
    }
}
