package ec.edu.espe.taxeslib.taxes;

/**
 *
 * - Iva
 * - Impuesto a la Renta
 * - ICE
 * @author LABS-ESPE
 * @version 1.0
 * 
 */
public class Tax {
    
    /**
     * It computes the sales taxes for products in Ecuador
     * @param base Base price of the product
     * @param taxPercentage Tax percentage that is regulated by the government
     * @return The value of sales taxes that a product produces
     */
    
    public static float computeIva(float base, float taxPercentage){
        float ivaValue;
        
        //TODO code
        ivaValue = base * taxPercentage/100;
        
        return ivaValue;
    }
    
    public static float computeTotal(float base, float taxPercentage){
        float total;
        total = base + computeIva(base, taxPercentage);
       
        return total;
    }
}
