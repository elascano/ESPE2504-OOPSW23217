
package ec.edu.espe.model;

/**
 *
 * @author LABS-ESPE
 */
public class Paypal implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using PayPal.");
    }
}
