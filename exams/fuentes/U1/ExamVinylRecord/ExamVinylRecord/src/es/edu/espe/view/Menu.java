package es.edu.espe.view;

import ec.edu.espe.model.VinylRecord;
import java.util.Scanner;

/**
 *
 * @author LABS-ESPE
 */
public class Menu {
    public static void showPrincipalMenu() {
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("--- Vinyls Record ---");
            System.out.println("1. Vinyl record caracteristics");
            System.out.println("2. Show csv");

            System.out.print("Select an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    showSecondMenu();
                    break;
                case 2:
                    
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (choice != 0);
    }
    
    public static void showSecondMenu() {
        Scanner scanner = new Scanner(System.in);


        int choice;
        do {
            System.out.println("--- Vinyl record ---");
            System.out.println("1. Color");
            System.out.println("2. Size");
            System.out.println("0. Type");
            System.out.println("0. price");
            System.out.println("0. BACK");
            System.out.print("your option: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    VinylRecord.insertColor();
                    break;
                case 2:
                    
                    break;
                case 0:
                    System.out.println("Regresando...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (choice != 0);
    }
    
}
