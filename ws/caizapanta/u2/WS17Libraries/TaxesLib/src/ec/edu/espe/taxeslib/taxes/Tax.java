package ec.edu.espe.taxeslib.taxes;

/**
 * This class is used to compute some taxes in Ecuador such as:
 * - IVA
 * - Impuesto a la Renta
 * - ICE
 * @author Tammy Caizapanta
 * @version 1.0
 */
public class Tax {
    
    /**
     * This method computes the sales taxes of products in Ecuador
     * @param base Base price os the product
     * @param taxPercentage tax percentege that is regulated by the goverment
     * @return the value of taxes of sales taxes that a product produces
     */
    public static float computeIva(float base,float taxPercentage){
        
        float ivaValue;
        // this is were you put your very complex algorithm
        ivaValue = base * taxPercentage/100;
        
        return ivaValue;
                
    }
    
    public static float computeTotal(float base, float taxPercentage){
        
        float total;
        
        total = base + computeIva(base, taxPercentage);
             
        return total;
    }
}
