// File: src/ec/edu/espe/billingsystem/model/PaymentStrategy.java
package ec.edu.espe.billingsystem.model;

/**
 * Strategy interface for payment methods.
 * @author Carlos
 */
public interface PaymentStrategy {
    /**
     * Process a payment of the given amount.
     * @param amount the amount to pay
     */
    void pay(double amount);
}
