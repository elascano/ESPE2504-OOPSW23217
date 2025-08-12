package ec.edu.espe.paymentstrategy.model;

/**
 *
 * @author Tammy Caizapanta
 */
public class DigitalWalletStrategy implements PaymentStrategy {
    private String phone;

    public DigitalWalletStrategy(String phone) {
        this.phone = phone;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paying $" + amount + " using Digital Wallet linked to phone: " + phone);
    }
}
