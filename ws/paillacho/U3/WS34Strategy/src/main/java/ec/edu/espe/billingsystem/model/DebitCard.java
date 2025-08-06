// File: src/ec/edu/espe/billingsystem/model/DebitCard.java
package ec.edu.espe.billingsystem.model;

/**
 * Concrete strategy for Debit Card payments. Implements PaymentStrategy.  
 * Masks the card number for display.  
 * @author Carlos
 */
public class DebitCard implements PaymentStrategy {
    private String cardNumber;
    private String cardHolder;
    private String pin;

    public DebitCard(String cardNumber, String cardHolder, String pin) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.pin        = pin;
    }

    @Override
    public void pay(double amount) {
        System.out.printf(
            "Debiting $%.2f from debit card %s (holder: %s)%n",
             amount, mask(cardNumber), cardHolder
        );
    }

    private String mask(String number) {
        int len = number.length();
        String stars = "*".repeat(Math.max(0, len - 4));
        return stars + number.substring(len - 4);
    }
}
