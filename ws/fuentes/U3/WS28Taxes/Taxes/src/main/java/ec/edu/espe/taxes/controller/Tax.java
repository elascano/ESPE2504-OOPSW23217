package ec.edu.espe.taxes.controller;

/**
 *
 * @author LABS-ESPE
 */
public class Tax {
    
    public float computeTax(float basePrice, float percentage, boolean charged){
        float ivaValue;
        
        if(!charged){
            ivaValue = 0.0F;
            return 0.0f;
        }else{
            ivaValue = basePrice*percentage/100;
            
        }
        return ivaValue;
    }
    
    public float computeIce(float basePrice){
        //CODE THE COMPUTATION OD ICE
        return 0.0F;
    }
    
}
