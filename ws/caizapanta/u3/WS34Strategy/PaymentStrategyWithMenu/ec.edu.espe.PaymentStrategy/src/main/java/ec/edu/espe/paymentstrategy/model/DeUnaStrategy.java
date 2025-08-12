package ec.edu.espe.paymentstrategy.model;

/**
 *
 * @author Tammy Caizapanta
 */
public class DeUnaStrategy implements PaymentStrategy {
    private final String username;

    public DeUnaStrategy(String username) {
        this.username = username;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paying $" + amount + " using DeUna account: " + username);
    }
}
