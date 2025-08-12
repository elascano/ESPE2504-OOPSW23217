package ec.edu.espe.paymentstrategy.model;

/**
 *
 * @author Tammy Caizapanta
 */
public class CreditCardStrategy implements PaymentStrategy {
    private String cardNumber;

    public CreditCardStrategy(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paying $" + amount + " using Credit Card: " + cardNumber);
    }
}
