/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espe.mavenproject1;

/**
 *
 * @author Kevin Vaca Edison's OOP ESPE
 */
public class Calculator {
    public static void main(String[] args) {
        // Get the USTax singleton instance
        USTax taxCalculator = USTax.getInstance();
        
        // Example sales amount
        double saleAmount = 100.0;
        
        // Display current tax percentage
        System.out.println("Current Tax Percentage: " + 
                          taxCalculator.getTaxPercentage() + "%");
        
        // Calculate total with default tax
        double totalWithTax = taxCalculator.salesTotal(saleAmount);
        System.out.println("Sale Amount: $" + saleAmount);
        System.out.println("Total with Default Tax: $" + totalWithTax);
        
        // Change tax percentage (if needed)
        taxCalculator.setTaxPercentage(8.5); // Set to 8.5%
        
        // Calculate with new tax rate
        totalWithTax = taxCalculator.salesTotal(saleAmount);
        System.out.println("\nUpdated Tax Percentage: " + 
                          taxCalculator.getTaxPercentage() + "%");
        System.out.println("Total with Updated Tax: $" + totalWithTax);
    }
}