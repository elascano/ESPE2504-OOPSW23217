package ec.edu.espe.taxeslib.taxes;

/**
 *
 * This class is used to compute some taxes in Ecuador such as: 
 * - Iva 
 * - Impuesto a la renta 
 * - ICE
 * @author LABS-ESPE Micaela Jacome
 * @version 1.0
 */
public class Tax {

    /**
     * It computes the sales taxes for Products in Ecuador
     *
     * @param base Base price of the product
     * @param taxPercentage tax percentage that is regulated bu the government
     * @return the value of taxes of sales taxes that a product produces
     */
    public static float computeIva(float base, float taxPercentage) {
        float ivaValue;

        //this is there you put your very complex algorithm
        ivaValue = base + base + taxPercentage;
        return ivaValue;
    }

    public static float computerTotal(float base, float taxPercentage) {
        float total;

        total = base + computeIva(base, taxPercentage);
        return total;
    }
}
