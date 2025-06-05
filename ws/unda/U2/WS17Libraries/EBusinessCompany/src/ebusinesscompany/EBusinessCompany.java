package EBusinessCompany;

import ec.edu.espe.taxeslib.taxes.Tax;

/**
 *
 * @author 
 */
public class EBusinessCompany {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        float base = 10;
        float tax = 0;
        float taxPercentage = 15;
       
        tax = Tax.computeIva(base, taxPercentage);
        System.out.println("TAXES --> "+tax);
    }
   
}