package ebusinesscompany;

import ec.espe.edu.taxeslib.taxes.Tax;

/**
 *
 * @author Jahir Sivinta
 */
public class EbusinessCompany {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        float base = 10;
        float tax = 0;
        float taxPercentage = 15;
        
        // TODO code application logic here
        
        tax = Tax.computeIva(base, taxPercentage);
        System.out.println("taxes ----> " + tax);
    }
    
}
