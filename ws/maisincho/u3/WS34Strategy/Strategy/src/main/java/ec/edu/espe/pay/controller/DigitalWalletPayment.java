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
public class DigitalWalletPayment implements PaymentStrategy {

    private String walletId;

    public DigitalWalletPayment(String walletId) {
        this.walletId = walletId;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paying$" + amount + "  Wallet digital: " + walletId);
    }

}
