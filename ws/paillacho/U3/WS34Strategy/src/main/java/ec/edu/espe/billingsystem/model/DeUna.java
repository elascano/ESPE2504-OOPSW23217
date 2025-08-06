// File: src/ec/edu/espe/billingsystem/model/DeUna.java
package ec.edu.espe.billingsystem.model;

/**
 * Concrete strategy for DeUna payments (fictional gateway).  
 * Uses a customerId + apiKey for authentication.  
 * @author Carlos
 */
public class DeUna implements PaymentStrategy {
    private String customerId;
    private String apiKey;

    public DeUna(String customerId, String apiKey) {
        this.customerId = customerId;
        this.apiKey     = apiKey;
    }

    @Override
    public void pay(double amount) {
        System.out.printf(
            "Processing DeUna payment of $%.2f for customer ID %s%n",
             amount, customerId
        );
    }
}
