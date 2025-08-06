package ec.edu.espe.singleton.controller;

import ec.edu.espe.singleton.model.USTax;

public class Calculator {
    
    public static void calculateTax(double sale) {
        USTax tax = USTax.getInstance();
        
        double taxAmount = tax.getTaxAmount(sale);
        double total = tax.getSalesTotal(sale);
        
        System.out.printf(" Venta:    $%8.2f%n", sale);
        System.out.printf(" Impuesto: $%8.2f%n", taxAmount);
        System.out.printf(" Total:    $%8.2f%n", total);
    }
}
