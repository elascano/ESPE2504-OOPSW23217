package ebuisenesscompany;

import ec.edu.espe.taxeslib.taxes.Tax;

/**
 *
 * @author LABS-ESPE
 */
public class EbuisenessCompany {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        float base = 10;
        float tax = 0;
        float taxPercentage = 15;       

        tax = Tax.computeIva(base,taxPercentage);
        System.out.println("taxes ---> " + tax);
        
    }
    
}
