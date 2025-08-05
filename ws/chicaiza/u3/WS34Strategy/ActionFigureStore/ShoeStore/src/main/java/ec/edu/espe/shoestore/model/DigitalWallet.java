/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.actionfigurestore.model;

/**
 *
 * @author LABS-ESPE
 */
public class DigitalWallet implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Digital Wallet.");
    }
}