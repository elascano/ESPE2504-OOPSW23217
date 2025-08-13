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
public class DigitalCardPayment implements PaymentStrategy {

    private String cardId;

    public DigitalCardPayment(String cardId) {
        this.cardId = cardId;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paying $" + amount + " with digital ID card: " + cardId);
    }

}
