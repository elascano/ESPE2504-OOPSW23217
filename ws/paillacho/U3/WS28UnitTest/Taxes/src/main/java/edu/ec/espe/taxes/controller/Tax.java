package edu.ec.espe.taxes.controller;

/**
 *
 * @author Carlos Paillacho
 */
public class Tax {
    public float computeTax(float basePrice, float percentage, boolean charged){
        float ivaValue;
        if (!charged) {
            ivaValue = 0.0F;
        }else {
        ivaValue = basePrice * percentage/100;
    }   
        return ivaValue;
    }
    public float computeIce(float basePrice){
        return 0;
    }
}
