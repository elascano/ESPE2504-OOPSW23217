// File: src/ec/edu/espe/billingsystem/model/CreditCard.java
package ec.edu.espe.billingsystem.model;

/**
 * Concrete strategy for Credit Card payments. Implements PaymentStrategy.  
 * Masks the card number for display.  
 * @author Carlos
 */
public class CreditCard implements PaymentStrategy {
    private String cardNumber;
    private String cardHolder;
    private String cvv;
    private String expirationDate;

    public CreditCard(String cardNumber, String cardHolder, String cvv, String expirationDate) {
        this.cardNumber     = cardNumber;
        this.cardHolder     = cardHolder;
        this.cvv            = cvv;
        this.expirationDate = expirationDate;
    }

    @Override
    public void pay(double amount) {
        System.out.printf(
            "Charging $%.2f to credit card %s (holder: %s)%n",
             amount, mask(cardNumber), cardHolder
        );
    }

    private String mask(String number) {
        int len = number.length();
        String stars = "*".repeat(Math.max(0, len - 4));
        return stars + number.substring(len - 4);
    }
}
