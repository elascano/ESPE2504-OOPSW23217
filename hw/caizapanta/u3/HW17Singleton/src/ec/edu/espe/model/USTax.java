package ec.edu.espe.model;

/**
 * 
 * @author Tammy Caizapanta
 */

public class USTax {
    private static USTax instance;
    private float taxValue;

    private USTax() {
        taxValue = 0.08f;
    }

    public static USTax getInstance() {
        if (instance == null) {
            instance = new USTax();
        }
        return instance;
    }

    public float salesTotal(float basePrice) {
        return basePrice + (basePrice * taxValue);
    }

    public float getTaxValue() {
        return taxValue;
    }

    public void setTaxValue(float taxValue) {
        this.taxValue = taxValue;
    }
}