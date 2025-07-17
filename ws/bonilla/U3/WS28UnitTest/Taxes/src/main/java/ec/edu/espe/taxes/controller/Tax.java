package ec.edu.espe.taxes.controller;

/**
 *
 * @author Bonilla David Softcrafters
 */
public class Tax {

    public float computeTax(float basePrice, float percentage, boolean charged) {
        float ivaValue = 0.0f;
        if (!charged) {
            ivaValue = 0.0f;
        } else {
            ivaValue = basePrice * percentage / 100;
        }
        return ivaValue;
    }
    public float testComputeIce(float basePrice){
        System.out.println("computeIce");
        return basePrice;
    }
}
