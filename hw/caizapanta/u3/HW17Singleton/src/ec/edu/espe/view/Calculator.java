package ec.edu.espe.view;
import ec.edu.espe.model.USTax;

/**
 * 
 * @author Tammy Caizapanta
 */

public class Calculator {
    
    public static void main(String[] args) {
        
        USTax tax = USTax.getInstance();

        float basePrice = 100.0f;
        float total = tax.salesTotal(basePrice);

        System.out.println("Final price: $" + total);
    }
}