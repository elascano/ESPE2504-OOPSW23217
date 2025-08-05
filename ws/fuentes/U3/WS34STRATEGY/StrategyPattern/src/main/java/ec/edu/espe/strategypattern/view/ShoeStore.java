/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espe.strategypattern.view;

import ec.edu.espe.strategypattern.controller.PaymentController;
import ec.edu.espe.strategypattern.model.PaymentContext;
import java.util.Scanner;

/**
 *
 * @author LABS-ESPE
 */
public class ShoeStore {

    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();
        PaymentController controller = new PaymentController(context);

        controller.processPayment();
    }
}
