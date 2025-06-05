package ec.edu.espe.taxeslib.taxes;

/**
 *-Ice
 * @author LABS-ESPE
 * @version 1.0
 */
public class Tax {
  /**
   * Ir computes the sales for products in Ecuador 
   * *@PARAM base base price of the product 
   * @PARAM taxPercentage tax percentage that is regulated by the government
   * @return tha value of sales taxes a product produces 
   */
    public static float computeIva(float base, float taxPercentage){
        float total;
        total = base *taxPercentage/100;
        return total;
    }
    public static float computeTotal(float base, float taxPercentage){
        float total;
        
        total = base + computeIva(base, taxPercentage);
        return total;
    }    

}
