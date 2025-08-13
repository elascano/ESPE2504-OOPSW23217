/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package ec.edu.espe.pay.view;

import ec.edu.espe.pay.controller.DeUnaPayment;
import ec.edu.espe.pay.controller.PaymentController;

/**
 *
 * @author LABS-ESPE
 */
public class PaymentApp {

    public static void main(String[] args) {

        DeUnaPayment deUna = new DeUnaPayment();

        PaymentController controller = new PaymentController(deUna);

        controller.selectPaymentMethod("paypal", "user@example.com");
        controller.makePayment(120.0);

        controller.selectPaymentMethod("creditcard", "1234-5678-9999-0000");
        controller.makePayment(250.0);

        controller.selectPaymentMethod("digitalcard", "DGT-4455");
        controller.makePayment(75.0);

        controller.selectPaymentMethod("digitalwallet", "WLT-789");
        controller.makePayment(180.0);
    }
}
