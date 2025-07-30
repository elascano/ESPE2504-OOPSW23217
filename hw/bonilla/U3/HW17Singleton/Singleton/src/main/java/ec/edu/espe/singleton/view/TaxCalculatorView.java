package ec.edu.espe.singleton.view;

import ec.edu.espe.singleton.controller.Calculator;
import ec.edu.espe.singleton.model.USTax;
import java.util.Scanner;

/**
 * 
 * @author David Bonilla SoftCrafters ESPE
 */
public class TaxCalculatorView {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Tax Calculator");
        System.out.println("Tax: 15%\n");
        
        while (true) {
            System.out.print("Ingresa el monto:");
            double saleAmount = scanner.nextDouble();
            
            if (saleAmount == 0) {
                System.exit(0);
                break;
            }else{
                System.out.println(USTax.getInstance().getSalesTotal(saleAmount));
            }
        }
    }
}
