package model;

public class DebitCardPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Debit Card.");
    }
}
