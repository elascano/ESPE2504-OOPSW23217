package ec.edu.espe.controller;

/**
 *
 * @author BERNARDO SUAREZ
 */
public class Tax {

    public float computeTax(float basePrice, float percentage, boolean charged) {
        float ivaValue = 0.0F;

        if (!charged) {
            return 0.0F;
        } else {
            ivaValue = basePrice * (percentage / 100);
        }
        return ivaValue;
    }
    
    public float computeIce(float basePrice){
        //code to compute ICE
        return 0.0F;
    }
    
}
