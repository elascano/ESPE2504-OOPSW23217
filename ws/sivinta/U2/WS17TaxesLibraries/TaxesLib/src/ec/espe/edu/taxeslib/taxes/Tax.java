package ec.espe.edu.taxeslib.taxes;

/**
 * this class is used to compute some taxes in Ecuador such as:
 * -IVA
 * -Impuesto a la renta
 * ICE
 * @author Jahir Sivinta
 * @version 1.0
 */
public class Tax {
    
    /**
     * It computes the sales taxes for Products in Ecuador  
     * @param base Base price of the product
     * @param taxPercentage tax percentage that is regulated by the goberment 
     * @return the value of sales taxes tat a produc produces
     */
    public static float computeIva(float base, float taxPercentage){
        float ivaValue;
        
        //this iswhere you put very complex algorithm
        ivaValue = base * taxPercentage/100;
        return ivaValue;
    }
    public static float computeTotal(float base, float taxPercentage){
        float total;
        total = base + computeIva(base, taxPercentage);
        return total;
    }
}
