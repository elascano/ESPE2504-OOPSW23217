package model;

public class DeUnaPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using DeUna.");
    }
}
