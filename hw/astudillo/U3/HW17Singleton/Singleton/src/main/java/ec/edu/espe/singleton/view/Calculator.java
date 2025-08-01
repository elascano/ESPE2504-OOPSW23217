package ec.edu.espe.singleton.view;

import ec.edu.espe.singleton.model.USTax;

/**
 * Calculator class
 * @author Astudillo
 */
public class Calculator {
    
    public static void main(String[] args) {
        USTax tax = USTax.getInstance();
        System.out.println("Sales Total: " + tax.salesTotal());
    }
}
