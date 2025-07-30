package ec.edu.espe.view;
import ec.edu.espe.model.USTax;

public class Calculator {
    
    public static void main(String[] args) {
        
        USTax tax = USTax.getInstance();

        float basePrice = 20f;
        float total = tax.salesTotal(basePrice);

        System.out.println("Final price = $" + total);
    }
}