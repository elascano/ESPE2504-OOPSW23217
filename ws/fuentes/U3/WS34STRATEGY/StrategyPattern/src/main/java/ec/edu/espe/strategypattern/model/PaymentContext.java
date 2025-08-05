/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.strategypattern.model;

/**
 *
 * @author LABS-ESPE
 */
public class PaymentContext {
    private PaymentStrategy strategy;

    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void pay(double amount) {
        if (strategy == null) {
            System.out.println("No payment method selected.");
        } else {
            strategy.pay(amount);
        }
    }
    
}
