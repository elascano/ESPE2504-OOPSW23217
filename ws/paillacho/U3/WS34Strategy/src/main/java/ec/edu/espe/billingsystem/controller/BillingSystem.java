// File: src/ec/edu/espe/billingsystem/controller/BillingSystem.java
package ec.edu.espe.billingsystem.controller;

import ec.edu.espe.billingsystem.model.PaymentStrategy;

/**
 * Context for billing: holds a PaymentStrategy and delegates checkout().  
 * No main() here anymore—view layer handles user interaction.  
 * @author Carlos
 */
public class BillingSystem {
    private PaymentStrategy strategy;

    public BillingSystem(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Delegate to the current payment strategy.
     * @param amount the amount to pay
     */
    public void checkout(double amount) {
        strategy.pay(amount);
    }
}
