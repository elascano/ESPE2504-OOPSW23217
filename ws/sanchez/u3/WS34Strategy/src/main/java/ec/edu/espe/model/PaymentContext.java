
package ec.edu.espe.model;

/**
 *
 * @author LABS-ESPE
 */

public class PaymentContext {
    private PaymentStrategy strategy;

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void executePayment(double amount) {
        if (strategy == null) {
            System.out.println("Payment strategy not set.");
            return;
        }
        strategy.pay(amount);
   }
}