package ec.espe.edu.question33.view;

import ec.espe.edu.question33.controller.FileManagerCellphone;
import ec.espe.edu.question33.model.Cellphone;
import java.util.Scanner;

/**
 *
 * @author Bonilla David SoftCrafters
 */
public class Question33 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("____________System Cellphone____________");
        System.out.println("1. Create a cellphone.");
        int option = Integer.parseInt(scanner.nextLine());
        
        switch (option) {
                case 1:
                    System.out.println("Input id: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.println("Input width: ");
                    int width = Integer.parseInt(scanner.nextLine());
                    System.out.println("Input height: ");
                    int height = Integer.parseInt(scanner.nextLine());
                    System.out.println("Input type: ");
                    String type = scanner.nextLine();                   
                    Cellphone cellphone = new Cellphone (id,width,height,type);
                    
                    FileManagerCellphone.saveCellphoneToCSV(cellphone);
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }
                
    }

}
