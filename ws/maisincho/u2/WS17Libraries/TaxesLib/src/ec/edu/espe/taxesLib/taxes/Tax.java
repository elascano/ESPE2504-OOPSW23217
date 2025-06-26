
package ec.edu.espe.taxesLib.taxes;

/**
 * This class is used to compute some taxes in Ecuador such as:
 * - Iva
 * - Impuesto a la renta 
 * - ICE
 * @author Isaac Maisincho
 * @version 1.0
 */
public class Tax {
    /**
     * It compute the sales taxes for products in Ecuador  
     * @param base Base price of the product
     * @param taxPercentage tax percentage that is regulated by the government 
     * @return the value of sales taxes that a product produces
     */
    public static float computeIva(float base, float taxPercentage){
        float ivaValue;
        //this is where you put youe very complex algorithm
        ivaValue= base *taxPercentage/100;
        return ivaValue;
    }
    public static float computeTotal(float base, float taxPercentage){
        float total;
        total = base +computeIva(base, taxPercentage);
        return total;
    }
}