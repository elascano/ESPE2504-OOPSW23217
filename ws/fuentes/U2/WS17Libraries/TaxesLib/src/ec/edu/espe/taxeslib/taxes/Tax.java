package ec.edu.espe.taxeslib.taxes;

/**
 *This class is used to compute some taxes in Ecuador such as:
 * -Iva
 * -Impuesto a la Renta
 * -ICE
 * @author Jorge Fuentes
 * @version 1.0
 */
public class Tax {
    
    /**
     * Its computes the sales taxes for products in Ecuador
     * @param base Base price of the product
     * @param taxPercentage tax percentage that is regulated by the goverment
     * @return the valuea of sale taxes that a product produces
     */
    public static float computeIva(float base, float taxPercentage){
        float ivaValue;
        
        //this is where you put your very complex algorith,
        ivaValue = base * taxPercentage/100;
        return ivaValue;
    }
    
    public static float computeTotal(float base, float taxPercentage){
        float total;
        
        total=base + computeIva(base, taxPercentage);
        return total;
    }
}
