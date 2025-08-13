/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.pay.controller;

import ec.edu.espe.pay.model.PaymentStrategy;

/**
 *
 * @author LABS-ESPE
 */
public class CreditCardPayment implements PaymentStrategy {

    private String cardNumber;
    private String cardHolder;

    public CreditCardPayment(String cardNumber, String cardHolder) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paying $" + amount + " with credit card: " + cardHolder);
    }

}
