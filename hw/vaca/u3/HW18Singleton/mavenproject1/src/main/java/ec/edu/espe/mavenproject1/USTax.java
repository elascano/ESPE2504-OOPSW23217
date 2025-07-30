/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.mavenproject1;

/**
 *
 * @author Kevin Vaca Edison's OOP ESPE
 */
public class USTax {
    private static USTax instance;
    
    private double taxPercentage;

    private USTax() {
        this.taxPercentage = 7.0;
    }
    
    public static USTax getInstance() {
        if (instance == null) {
            instance = new USTax();
        }
        return instance;
    }
    
    public void setTaxPercentage(double percentage) {
    this.taxPercentage = percentage;
    }
    
    public double getTaxPercentage() {
    return taxPercentage;
    }
    
    // Method to calculate sales total with tax
    public double salesTotal(double amount) {
        return amount * (1 + (taxPercentage / 100));
    }
}
