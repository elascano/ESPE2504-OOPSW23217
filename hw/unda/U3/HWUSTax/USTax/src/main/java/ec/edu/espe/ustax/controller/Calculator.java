package ec.edu.espe.tax;

/**
 * Client class that uses USTax to calculate the total price with tax
 */
public class Calculator {

    public static void main(String[] args) {
        float price = 100.0F;

        // Get the Singleton instance of USTax
        USTax tax = USTax.getInstance();

        // Compute the tax
        float taxAmount = tax.computeTax(price);

        // Display the result
        System.out.println("Price: $" + price);
        System.out.println("Applied tax (" + tax.getTaxRate() * 100 + "%): $" + taxAmount);
        System.out.println("Total to pay: $" + (price + taxAmount));
    }
}
