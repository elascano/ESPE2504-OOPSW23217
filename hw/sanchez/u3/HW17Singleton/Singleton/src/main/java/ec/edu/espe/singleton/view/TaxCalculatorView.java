package ec.edu.espe.singleton.view;

import ec.edu.espe.singleton.controller.Calculator;
import java.util.Scanner;

public class TaxCalculatorView {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Calculadora de Impuestos ===");
        System.out.println("Tasa de Impuesto: 8.5%\n");
        
        while (true) {
            System.out.print("Ingresa el monto de venta (0 para salir): $");
            double saleAmount = scanner.nextDouble();
            
            if (saleAmount == 0) {
                System.out.println("¡Adiós!");
                break;
            }
            
            if (saleAmount > 0) {
                Calculator.calculateTax(saleAmount);
            } else {
                System.out.println("El monto debe ser positivo.");
            }
            System.out.println();
        }
        
        scanner.close();
    }
}
