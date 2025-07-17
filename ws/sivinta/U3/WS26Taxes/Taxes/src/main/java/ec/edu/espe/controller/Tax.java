package ec.edu.espe.controller;

/**
 *
 * @author Sivinta Jahir
 */
public class Tax {

    public float compuTax(float basePrice, float percentage, boolean charged) {
        float ivaValue = 0.0F;

        if (!charged) {
            ivaValue = 0.0F;
        } else {
            ivaValue = basePrice * percentage / 100;
        }
            return ivaValue;
        }
        
    public float computeIce(float basePrice) {
        return 0.0F;
    }
}
