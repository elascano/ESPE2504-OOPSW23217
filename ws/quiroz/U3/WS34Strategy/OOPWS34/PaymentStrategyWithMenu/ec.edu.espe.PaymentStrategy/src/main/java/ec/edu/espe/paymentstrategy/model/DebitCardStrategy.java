package ec.edu.espe.paymentstrategy.model;

/**
 *
 * @author LABS-ESPE
 */
public class DebitCardStrategy implements PaymentStrategy {
    private String cardNumber;

    public DebitCardStrategy(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paying $" + amount + " using Debit Card: " + cardNumber);
    }
}
