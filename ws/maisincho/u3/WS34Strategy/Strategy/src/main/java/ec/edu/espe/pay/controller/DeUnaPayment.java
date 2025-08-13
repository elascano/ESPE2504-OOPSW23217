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
public class DeUnaPayment implements PaymentStrategy {

    private PaymentStrategy strategy;

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void pay(double amount) {
        if (strategy == null) {
            System.out.println("No payment method selected in DeUna.");
        } else {
            strategy.pay(amount); 
        }
    }
}
