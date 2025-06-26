
package ec.espe.edu.view;

import ec.espe.edu.model.Laptop;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 *
 * @author Isaac Maisincho Crafters_Market DCCO ESPE
 */

public class appLaptop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Laptop laptop = null;
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Laptop Management ---");
            System.out.println("1. Enter Laptop Details");
            System.out.println("2. Show Laptop Details");
            System.out.println("3. Save Laptop");
            System.out.println("4. Load Laptop");
            System.out.println("5. Update Laptop");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            scanner.nextLine(); 

            switch (option) {
                case 1:
                    laptop = new Laptop();
                    laptop.inputLaptopDetails(scanner);
                    break;
                case 2:
                    if (laptop != null) {
                        System.out.println(laptop);
                    } else {
                        System.out.println("There is no charged laptop.");
                    }
                    break;
                case 3:
                    saveLaptop(laptop);
                    break;
                case 4:
                    laptop = loadLaptop();
                    break;
                case 5:
                    if (laptop != null) {
                        laptop.updateLaptopDetails(scanner);
                    } else {
                        System.out.println("There is no laptop to update.");
                    }
                    break;
                case 6:
                    exit = true;
                    System.out.println("exit...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }

    private static void saveLaptop(Laptop laptop) {
        if (laptop == null) {
            System.out.println("There is no laptop to store.");
            return;
        }
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("laptop.ser"))) {
            oos.writeObject(laptop);
            System.out.println("Laptop saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving laptop: " + e.getMessage());
        }
    }

    private static Laptop loadLaptop() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("laptop.ser"))) {
            Laptop laptop = (Laptop) ois.readObject();
            System.out.println("Laptop charged successfully.");
            return laptop;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading the laptop: " + e.getMessage());
            return null;
        }
    }
}