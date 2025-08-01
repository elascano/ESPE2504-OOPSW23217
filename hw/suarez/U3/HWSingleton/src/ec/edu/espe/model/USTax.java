package ec.edu.espe.model;

/**
 * 
@author Bernardo Suarez
* 
*/

public class USTax { //add "public"
    private static USTax instance;
    private float taxRate;

    private USTax() {
        taxRate = 0.1f; //e.g. 10%, changes by state
    }

    public static USTax getInstance() {
        if (instance == null) {
            instance = new USTax();
        }
        return instance;
    }

    public float salesTotal(float basePrice) {
        return basePrice + (basePrice * taxRate);
    }

    
    //setters getters:
    
    public float getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(float taxRate) {
        this.taxRate = taxRate;
    }
}