package ec.edu.espe.controller;

import ec.edu.espe.model.paymentStrategy;
import ec.edu.espe.model.*;
import java.util.Scanner;

/**
 *
 * @author BERNARDO
 */

public class paymentMethod {

    private paymentStrategy strategy;

    public void setPaymentStrategy(paymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void processPayment(double amount) {
        if (strategy != null) {
            strategy.pay(amount);
        } else {
            System.out.println("No payment method selected.");
        }
    }
    
    public void showMenu() {
        System.out.println("¬ Select payment method:  BS");
        System.out.println("1. Credit Card");
        System.out.println("2. Debit Card");
        System.out.println("3. deUna");
        System.out.println("4. Digital Wallet");
        System.out.println("5. PayPal");
        System.out.println("0. Exit");
    }

    public int getChoice(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;  // invalid input
        }
    }

    public double getAmount(Scanner scanner) {
        try {
            double amount = Double.parseDouble(scanner.nextLine());
            return amount > 0 ? amount : -1;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public paymentStrategy getStrategyByChoice(int choice) {
        return switch (choice) {
            case 1 -> new creditCard();
            case 2 -> new debitCard();
            case 3 -> new deUna();
            case 4 -> new digitalWallet();
            case 5 -> new paypal();
            default -> null;
        };
    }

    public String getStrategyName(int choice) {
        return switch (choice) {
            case 1 -> "Credit Card";
            case 2 -> "Debit Card";
            case 3 -> "deUna";
            case 4 -> "Digital Wallet";
            case 5 -> "PayPal";
            default -> "Unknown";
        };
    }
}
