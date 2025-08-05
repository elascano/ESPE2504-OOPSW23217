/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.actionfigurestore.view;

import java.util.Scanner;

/**
 *
 * @author LABS-ESPE
 */
public class PaymentView {
    private final Scanner scanner = new Scanner(System.in);

    public double getAmount() {
        System.out.print("Enter the price of product: ");
        return scanner.nextDouble();
    }

    public int getPaymentChoice() {
         System.out.println("**********Payment Menu**********");
        System.out.println("Choose a payment method:");
        System.out.println("1. PayPal");
        System.out.println("2. Credit Card");
        System.out.println("3. Debit Card");
        System.out.println("4. Digital Wallet");
        System.out.println("5. De una");
        System.out.println("**************************");
        return scanner.nextInt();
    }

    public void showInvalidChoice() {
        System.out.println("Invalid payment method.");
    }
}