/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ebusinesscompany;
import ec.edu.espe.taxeslib.taxes.Tax;

/**
 *
 * @author José Yánez
 */
public class EbusinessCompany {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        float base = 10.3F;
        float tax = 0;
        float taxPercentage = 15;
        
        
        tax = Tax.computeIva(base, taxPercentage);
        System.out.println("TAXES --> "+tax);
    }
    
}
