package ec.edu.espe.model;

/**
 *
 * @author BERNARDO
 */

public class digitalWallet implements paymentStrategy {
    
    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Digital Wallet.");
    }
    
}
