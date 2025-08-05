// File: src/ec/edu/espe/billingsystem/view/Menu.java
package ec.edu.espe.billingsystem.view;

import ec.edu.espe.billingsystem.controller.BillingSystem;
import ec.edu.espe.billingsystem.model.*;
import java.util.Scanner;

/**
 * Simple console menu to select payment method and process a payment.  
 * @author Carlos
 */
public class Menu {
    private Scanner scanner = new Scanner(System.in);

    public void show() {
        BillingSystem system;

        while (true) {
            System.out.println("\n=== Billing System Menu ===");
            System.out.println("1) Pay with PayPal");
            System.out.println("2) Pay with Credit Card");
            System.out.println("3) Pay with Debit Card");
            System.out.println("4) Pay with DeUna");
            System.out.println("5) Exit");
            System.out.print("Select an option: ");

            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 5) {
                System.out.println("Goodbye!");
                break;
            }

            System.out.print("Enter amount: $");
            double amount = Double.parseDouble(scanner.nextLine());

            switch (choice) {
                case 1 -> {
                    System.out.print("PayPal email: ");
                    String email = scanner.nextLine();
                    System.out.print("PayPal password: ");
                    String pwd = scanner.nextLine();
                    system = new BillingSystem(new Paypal(email, pwd));
                }
                case 2 -> {
                    System.out.print("Card number: ");
                    String ccNum = scanner.nextLine();
                    System.out.print("Card holder: ");
                    String ccHolder = scanner.nextLine();
                    System.out.print("CVV: ");
                    String cvv = scanner.nextLine();
                    System.out.print("Expiration date (MM/YY): ");
                    String exp = scanner.nextLine();
                    system = new BillingSystem(new CreditCard(ccNum, ccHolder, cvv, exp));
                }
                case 3 -> {
                    System.out.print("Card number: ");
                    String dcNum = scanner.nextLine();
                    System.out.print("Card holder: ");
                    String dcHolder = scanner.nextLine();
                    System.out.print("PIN: ");
                    String pin = scanner.nextLine();
                    system = new BillingSystem(new DebitCard(dcNum, dcHolder, pin));
                }
                case 4 -> {
                    System.out.print("DeUna customer ID: ");
                    String custId = scanner.nextLine();
                    System.out.print("DeUna API key: ");
                    String apiKey = scanner.nextLine();
                    system = new BillingSystem(new DeUna(custId, apiKey));
                }
                default -> {
                    System.out.println("Invalid option. Try again.");
                    continue;
                }
            }

            system.checkout(amount);
        }
    }

    public static void main(String[] args) {
        new Menu().show();
    }
}
