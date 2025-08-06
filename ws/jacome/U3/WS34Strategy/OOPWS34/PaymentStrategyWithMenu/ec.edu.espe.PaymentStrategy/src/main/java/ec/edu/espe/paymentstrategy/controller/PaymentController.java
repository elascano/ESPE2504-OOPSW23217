package ec.edu.espe.paymentstrategy.controller;

import ec.edu.espe.paymentstrategy.model.CreditCardStrategy;
import ec.edu.espe.paymentstrategy.model.DeUnaStrategy;
import ec.edu.espe.paymentstrategy.model.DebitCardStrategy;
import ec.edu.espe.paymentstrategy.model.DigitalWalletStrategy;
import ec.edu.espe.paymentstrategy.model.PayPalStrategy;
import ec.edu.espe.paymentstrategy.model.PaymentContext;
import ec.edu.espe.paymentstrategy.view.PaymentView;

/**
 *
 * @author LABS-ESPE
 */

public class PaymentController {
    private PaymentContext paymentContext;
    private PaymentView view;

    public PaymentController(PaymentContext context, PaymentView view) {
        this.paymentContext = context;
        this.view = view;
    }

    public void payWithPayPal(String email, double amount) {
        paymentContext.setPaymentStrategy(new PayPalStrategy(email));
        executePayment(amount);
    }

    public void payWithCreditCard(String cardNumber, double amount) {
        paymentContext.setPaymentStrategy(new CreditCardStrategy(cardNumber));
        executePayment(amount);
    }

    public void payWithDebitCard(String cardNumber, double amount) {
        paymentContext.setPaymentStrategy(new DebitCardStrategy(cardNumber));
        executePayment(amount);
    }

    public void payWithDigitalWallet(String phone, double amount) {
        paymentContext.setPaymentStrategy(new DigitalWalletStrategy(phone));
        executePayment(amount);
    }

    public void payWithDeUna(String username, double amount) {
        paymentContext.setPaymentStrategy(new DeUnaStrategy(username));
        executePayment(amount);
    }

    private void executePayment(double amount) {
        try {
            paymentContext.executePayment(amount);
            view.showPaymentResult("Payment of $" + amount + " was successful.");
        } catch (Exception e) {
            view.showError(e.getMessage());
        }
    }
}
