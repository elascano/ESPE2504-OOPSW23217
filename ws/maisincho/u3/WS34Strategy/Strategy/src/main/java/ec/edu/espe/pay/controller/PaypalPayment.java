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
public class PaypalPayment implements PaymentStrategy {

    private String email;

    @Override
    public void pay(double amount) {
        System.out.println("Paying $" + amount + " paypal used correo: " + email);
    }

    public PaypalPayment(String email) {
        this.email = email;
    }

}
