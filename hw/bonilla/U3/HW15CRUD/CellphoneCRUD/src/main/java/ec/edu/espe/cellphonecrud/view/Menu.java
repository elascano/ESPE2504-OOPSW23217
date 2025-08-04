package ec.edu.espe.cellphonecrud.view;

import ec.edu.espe.cellphonecrud.controller.FileManagerCellphone;
import ec.edu.espe.cellphonecrud.model.Cellphone;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Bonilla David SoftCrafters
 */
public class Menu {

    public static void principalMenu() {
        Scanner scanner = new Scanner(System.in);
        int option;

        while (true) {
            System.out.println("____________System Cellphone____________");
            System.out.println("""
                               1. Create a cellphone.
                               2. Read cellphones.
                               3. Update a cellphone.
                               4. Delete a cellphone.
                               5. Exit.""");
            System.out.print("Enter your option: ");
            option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1 -> {
                    System.out.print("Enter id: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter width: ");
                    int width = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter height: ");
                    int height = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter type: ");
                    String type = scanner.nextLine();

                    double priceFinal = Cellphone.calculateManufacturingCost(type);
                    Cellphone cellphone = new Cellphone(id, width, height, type, priceFinal);
                    FileManagerCellphone.saveCellphoneMongoDB(cellphone);
                }
                case 2 -> {
                    List<Cellphone> cellphones = FileManagerCellphone.readCellphonesMongoDB();

                    if (cellphones.isEmpty()) {
                        System.out.println("There are no cellphones stored.");
                    } else {
                        System.out.println("________List of Cellphones_______");
                        for (Cellphone cellphone : cellphones) {
                            System.out.println("ID: " + cellphone.getId());
                            System.out.println("Width: " + cellphone.getWidth()+" cm");
                            System.out.println("Height: " + cellphone.getHeight()+" cm");
                            System.out.println("Type: " + cellphone.getType());
                            System.out.println("Precio Final: $" + cellphone.getPriceFinal());
                            System.out.println("___________________________________");
                        }
                    }
                }
                case 3 -> {
                    System.out.print("Enter the ID of the cellphone to update: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    FileManagerCellphone.updateCellphoneMongoDB(id);
                }
                case 4 -> {
                    System.out.print("Enter the ID of the cellphone to delete: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    FileManagerCellphone.deleteCellphoneMongoDB(id);
                }
                case 5 -> {
                    System.exit(0);
                    scanner.close();
                }
                default -> System.out.println("Invalid option");
            }
            System.out.println();
        }
    }
}
