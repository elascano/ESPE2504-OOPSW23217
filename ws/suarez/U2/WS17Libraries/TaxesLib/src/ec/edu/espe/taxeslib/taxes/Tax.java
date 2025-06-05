package ec.edu.espe.taxeslib.taxes;

/**
 *
 * This class is used to compute some taxes in Ecuador, such as:
 * - Iva
 * - Impuesto a la Renta
 * - ICE
 * @author Bernardo Suarez
 * @version 1.0
 */
public class Tax {
    /**
     * It computes the sales taxes for Products in Ecuador
     * @param base base price of the product
     * @param taxPercentage tax percentage that is regulated by the government
     * @return the value of sales taxes tgat a product produces
     */
    
    public static float computeIva(float base, float taxPercentage){
        float ivaValue;
        
        ivaValue = base * taxPercentage/100;
        
        return ivaValue;
    }
    
    public static float computeTotal(float base, float taxPecentage){
        float total;
        total = base + computeIva(base, taxPecentage);
        return total;
    }
}
