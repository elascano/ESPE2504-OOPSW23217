/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.strategypattern.controller;

import ec.edu.espe.strategypattern.model.CreditCard;
import ec.edu.espe.strategypattern.model.DeUna;
import ec.edu.espe.strategypattern.model.DebitCard;
import ec.edu.espe.strategypattern.model.DigitalWallet;
import ec.edu.espe.strategypattern.model.PayPal;
import ec.edu.espe.strategypattern.model.PaymentContext;
import ec.edu.espe.strategypattern.model.PaymentStrategy;
import java.util.Scanner;

/**
 *
 * @author LABS-ESPE
 */
public class PaymentController {
    private final PaymentContext context;
    private final Scanner scanner = new Scanner(System.in);

    public PaymentController(PaymentContext context) {
        this.context = context;
    }

    public void processPayment() {
        System.out.print("Enter amount to pay: ");
        double amount = scanner.nextDouble();

        System.out.println("Choose a payment method:");
        System.out.println("1. PayPal");
        System.out.println("2. Credit Card");
        System.out.println("3. Debit Card");
        System.out.println("4. Digital Wallet");
        System.out.println("5. Deuna");

        int choice = scanner.nextInt();
        PaymentStrategy strategy;

        switch (choice) {
            case 1 -> strategy = new PayPal();
            case 2 -> strategy = new CreditCard();
            case 3 -> strategy = new DebitCard();
            case 4 -> strategy = new DigitalWallet();
            case 5 -> strategy = new DeUna();
            default -> {
                System.out.println("Invalid payment method.");
                return;
            }
        }

        context.setStrategy(strategy);
        context.pay(amount);
    }
    
}
