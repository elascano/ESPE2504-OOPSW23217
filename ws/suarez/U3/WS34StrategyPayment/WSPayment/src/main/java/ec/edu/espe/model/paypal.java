package ec.edu.espe.model;

/**
 *
 * @author BERNARDO
 */

public class paypal implements paymentStrategy {
    
    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using PayPal.");
    }
    
}
