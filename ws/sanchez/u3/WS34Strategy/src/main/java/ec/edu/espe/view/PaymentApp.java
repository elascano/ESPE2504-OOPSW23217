
package ec.edu.espe.view;

/**
 *
 * @author Julio Sanchez
 */

import ec.edu.espe.controller.PaymentController;
import java.util.Scanner;

public class PaymentApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PaymentController controller = new PaymentController();

        System.out.print("Enter payment amount: ");
        double amount = scanner.nextDouble();

        System.out.println("Choose payment method:");
        System.out.println("1. Digital Wallet");
        System.out.println("2. Credit Card");
        System.out.println("3. Debit Card");
        System.out.println("4. Deuna");
        System.out.println("5. PayPal");
        int choice = scanner.nextInt();

        try {
            controller.setPaymentMethod(choice);
            controller.processPayment(amount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}
