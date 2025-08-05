
package ec.edu.espe.controller;
import ec.edu.espe.model.*;

/**
 *
 * @author LABS-ESPE
 */


public class PaymentController {
    private PaymentContext context;

    public PaymentController() {
        context = new PaymentContext();
    }

    public void setPaymentMethod(int option) {
        switch (option) {
            case 1 -> context.setPaymentStrategy(new DigitalWallet());
            case 2 -> context.setPaymentStrategy(new PaymentCredit());
            case 3 -> context.setPaymentStrategy(new DebitPayment());
            case 4 -> context.setPaymentStrategy(new Deuna());
            case 5 -> context.setPaymentStrategy(new Paypal());
            default -> throw new IllegalArgumentException("Invalid option");
        }
    }

    public void processPayment(double amount) {
        context.executePayment(amount);
    }
}
