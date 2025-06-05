
package ec.espe.edu.taxeslib.taxes;

/**
 *
 *
 * @author Sanchez Julio
 * 
 */

public class Tax {

    public static float computeIva;
    
    /**
     * It computes the sales taxes for Products in Ecuador
     * @param base Base price of the product
     * @param taxPercentage Tax percentage that is regulated by the goverment
     * @return the value of sales taxes that a product produces
     */
    
    public static float computeIva(float base, float taxPercentage){
        float ivaValue;
        
        ivaValue = base * taxPercentage/100;
        
        return ivaValue;
    }
    
    public static float computeTotal(float base, float taxPercentage){
        float total;
        
        total = base + computeIva(base , taxPercentage);
        
        return total;
    }
    
}
