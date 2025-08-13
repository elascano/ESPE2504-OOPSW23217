/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.pay.controller;

/**
 *
 * @author LABS-ESPE
 */
public class PaymentController {

    private DeUnaPayment deUnaPayment;

    public PaymentController(DeUnaPayment deUnaPayment) {
        this.deUnaPayment = deUnaPayment;
    }

    public void selectPaymentMethod(String method, String identifier) {
        switch (method.toLowerCase()) {
            case "paypal":
                deUnaPayment.setPaymentStrategy(new PaypalPayment(identifier));
                break;
            case "creditcard":
                deUnaPayment.setPaymentStrategy(new CreditCardPayment(identifier, "Default Holder"));
                break;
            case "digitalcard":
                deUnaPayment.setPaymentStrategy(new DigitalCardPayment(identifier));
                break;
            case "digitalwallet":
                deUnaPayment.setPaymentStrategy(new DigitalWalletPayment(identifier));
                break;
            default:
                System.out.println("Invalid payment method: " + method);
                break;
        }
    }

    public void makePayment(double amount) {
        deUnaPayment.pay(amount);
    }
}
