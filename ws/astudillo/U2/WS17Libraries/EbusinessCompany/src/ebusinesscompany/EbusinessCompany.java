package ebusinesscompany;

import ec.edu.espe.taxeslib.taxes.Taxes;
/**
 *
 * @author Gerald Astudillo
 */
public class EbusinessCompany {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        float base=10;
        float tax=0;
        float taxPercentage=15;
        
        tax= Taxes.computeIva(base, taxPercentage);
        System.out.println("taxes: "+tax);
    }
    
}
