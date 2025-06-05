package ebusinesscompany;
import ec.edu.espe.taxeslib.taxes.Tax;
/**
 *
 * @author Tammy Caizapanta
 */
public class EbusinessCompany {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        float base=10.3F;
        float tax =0;
        float taxPercentage=15;
        
        tax = Tax.computeIva(base,taxPercentage);
        System.out.println("taxes-->" + tax);
        
    }
    
}
