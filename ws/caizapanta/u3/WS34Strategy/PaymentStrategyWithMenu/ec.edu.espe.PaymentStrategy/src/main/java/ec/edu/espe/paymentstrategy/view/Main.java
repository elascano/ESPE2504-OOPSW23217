package ec.edu.espe.paymentstrategy.view;

import ec.edu.espe.paymentstrategy.controller.PaymentController;
import ec.edu.espe.paymentstrategy.model.PaymentContext;

/**
 *
 * @author Tammy Caizapanta
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();
        PaymentView view = new PaymentView();
        PaymentController controller = new PaymentController(context, view);

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n===== Payment Menu =====");
            System.out.println("1. Pay with PayPal");
            System.out.println("2. Pay with Credit Card");
            System.out.println("3. Pay with Debit Card");
            System.out.println("4. Pay with Digital Wallet");
            System.out.println("5. Pay with DeUna");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter PayPal email: ");
                    String email = scanner.nextLine();
                    double paypalAmount = readAmount(scanner);
                    controller.payWithPayPal(email, paypalAmount);
                    break;

                case "2":
                    System.out.print("Enter Credit Card number: ");
                    String creditCard = scanner.nextLine();
                    double creditAmount = readAmount(scanner);
                    controller.payWithCreditCard(creditCard, creditAmount);
                    break;

                case "3":
                    System.out.print("Enter Debit Card number: ");
                    String debitCard = scanner.nextLine();
                    double debitAmount = readAmount(scanner);
                    controller.payWithDebitCard(debitCard, debitAmount);
                    break;

                case "4":
                    System.out.print("Enter phone for Digital Wallet: ");
                    String phone = scanner.nextLine();
                    double walletAmount = readAmount(scanner);
                    controller.payWithDigitalWallet(phone, walletAmount);
                    break;

                case "5":
                    System.out.print("Enter DeUna username: ");
                    String username = scanner.nextLine();
                    double deunaAmount = readAmount(scanner);
                    controller.payWithDeUna(username, deunaAmount);
                    break;

                case "0":
                    exit = true;
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }

    private static double readAmount(Scanner scanner) {
        while (true) {
            System.out.print("Enter amount to pay: ");
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid amount. Please enter a numeric value.");
            }
        }
    }
}

