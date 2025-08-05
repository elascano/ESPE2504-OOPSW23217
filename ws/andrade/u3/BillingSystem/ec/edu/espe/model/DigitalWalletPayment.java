package model;

public class DigitalWalletPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Digital Wallet.");
    }
}
