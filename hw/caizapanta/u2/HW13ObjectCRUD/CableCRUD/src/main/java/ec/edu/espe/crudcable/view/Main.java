package ec.edu.espe.crudcable.view;

import java.util.Scanner;
import java.util.UUID;
import ec.edu.espe.cablecrud.model.CableDB;
import ec.edu.espe.cablecrud.model.CableDB;

/**
 *
 * @author Tammy Caizapanta SoftCrafters DCCO ESPE
 */
public class Main {
    public static void main(String[] args) {
        CableDB dao = new CableDB();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Create Cable");
            System.out.println("2. Read Cables");
            System.out.println("3. Update Price");
            System.out.println("4. Delete Cable");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int option = sc.nextInt();
            sc.nextLine(); // consume newline

            if (option == 1) {
                System.out.print("Type: ");
                String type = sc.nextLine();
                System.out.print("Length (meters): ");
                double length = sc.nextDouble();
                System.out.print("Price per meter: ");
                double price = sc.nextDouble();
                System.out.print("Stock quantity: ");
                int stock = sc.nextInt();
                sc.nextLine(); // consume newline

                Cable cable = new Cable(UUID.randomUUID().toString(), type, length, price, stock);
                dao.insertCable(cable);

            } else if (option == 2) {
                dao.showCables();

            } else if (option == 3) {
                System.out.print("Cable ID to update: ");
                String id = sc.nextLine();
                System.out.print("New price per meter: ");
                double newPrice = sc.nextDouble();
                sc.nextLine(); // consume newline

                dao.updatePrice(id, newPrice);

            } else if (option == 4) {
                System.out.print("Cable ID to delete: ");
                String id = sc.nextLine();

                dao.deleteCable(id);

            } else if (option == 5) {
                System.out.println("Exiting...");
                break;

            } else {
                System.out.println("Invalid option.");
            }
        }

        sc.close();
    }
}