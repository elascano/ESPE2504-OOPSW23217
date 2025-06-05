package ec.edu.espe.taxeslib.taxes;

/**
 *This class is used to compute come taxes in Ecuador 
 * @author Mateo Unda
 * @version 1.0
 */
public class Tax {
    
    /**
     * It computes the sales taxes for Products in Ecuador
     * @param base Base price of the product
     * @param taxPercentage tax percentage that is regulated by the governament
     * @return the value of sales taxes that a product produces
     */
    public static float computeIva(float base, float taxPercentage){
        float ivaValue;
        
        //This is where you put your very complex algoritm
        ivaValue = base * taxPercentage/100;
        
        return ivaValue;
    }
    
    public static float computerTotal(float base, float taxpercentage){
        float total;
        total = base + computeIva(base, taxpercentage);
        
        return total;
    }
}
