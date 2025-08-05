package ec.edu.espe.view;

import ec.edu.espe.controller.paymentMethod;
import ec.edu.espe.model.paymentStrategy;
import java.util.Scanner;

/**
 *
 * @author BERNARDO
 */

public class paymentApp {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        paymentMethod controller = new paymentMethod();

        while (true) {
            controller.showMenu();
            System.out.print("Enter your choice: ");
            int choice = controller.getChoice(scanner);

            if (choice == 0) {
                System.out.println("Exiting. Thank you!");
                break;
            }

            paymentStrategy strategy = controller.getStrategyByChoice(choice);
            if (strategy == null) {
                System.out.println("Invalid choice. Try again.");
                continue;
            }

            System.out.print("Enter amount to pay: ");
            double amount = controller.getAmount(scanner);

            if (amount <= 0) {
                System.out.println("Invalid amount. Must be a positive number.");
                continue;
            }

            controller.setPaymentStrategy(strategy);
            controller.processPayment(amount);

            System.out.println("Payment of $" + amount + " made using " + controller.getStrategyName(choice) + ".\n");
        }

        scanner.close();
    }
}
