// File: src/ec/edu/espe/billingsystem/model/Paypal.java
package ec.edu.espe.billingsystem.model;

/**
 * Concrete strategy for PayPal payments. Implements PaymentStrategy.
 * Simulates calling PayPal’s API.  
 * @author Carlos
 */
public class Paypal implements PaymentStrategy {
    private String email;
    private String password;

    public Paypal(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public void pay(double amount) {
        System.out.printf("Processing PayPal payment of $%.2f for %s%n", amount, email);
    }
}
