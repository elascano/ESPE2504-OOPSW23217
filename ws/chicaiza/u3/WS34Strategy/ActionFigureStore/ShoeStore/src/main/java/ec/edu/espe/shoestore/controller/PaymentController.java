/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.actionfigurestore.controller;

import ec.edu.espe.actionfigurestore.model.CreditCard;
import ec.edu.espe.actionfigurestore.model.DebitCard;
import ec.edu.espe.actionfigurestore.model.Deuna;
import ec.edu.espe.actionfigurestore.model.DigitalWallet;
import ec.edu.espe.actionfigurestore.model.PayPal;
import ec.edu.espe.actionfigurestore.model.PaymentContext;
import ec.edu.espe.actionfigurestore.view.PaymentView;

/**
 *
 * @author LABS-ESPE
 */

public class PaymentController {
    private final PaymentContext context;
    private final PaymentView view;

    public PaymentController(PaymentContext context, PaymentView view) {
        this.context = context;
        this.view = view;
    }

    public void processPayment() {
        double amount = view.getAmount();
        int choice = view.getPaymentChoice();

        switch (choice) {
            case 1 -> context.setStrategy(new PayPal());
            case 2 -> context.setStrategy(new CreditCard());
            case 3 -> context.setStrategy(new DebitCard());
            case 4 -> context.setStrategy(new DigitalWallet());
            case 5 -> context.setStrategy(new Deuna());
            default -> {
                view.showInvalidChoice();
                return;
            }
        }

        context.pay(amount);
    }
}
