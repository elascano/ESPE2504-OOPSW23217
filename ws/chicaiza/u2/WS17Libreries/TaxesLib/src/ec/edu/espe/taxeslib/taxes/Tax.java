package ec.edu.espe.taxeslib.taxes;

import java.io.*;

/**
 * This class is used to compute some taxes in Ecuador such as:
 * - IVA
 * - Impuesto a la Renta
 * - ICE
 * @author Chicaiza Amaguaña Michael Alexis
 * @version 1.0
 */
public class Tax {
    
    /**
     * Computes the sales taxes for Products in Ecuador
     * @param base Base price of the product
     * @param taxPercentage tax percentage that is regulated by the government
     * @return the value of sales taxes that a product produces
     */
    public static float computeIva(float base, float taxPercentage){
        float total;
        
        total = base*taxPercentage/100;
        
        return total;
    }
    
    public static float computeTotal(float base, float taxPercentage){
        float total;
        
        total = base + computeIva(base,taxPercentage);
        return total;
    }
}
