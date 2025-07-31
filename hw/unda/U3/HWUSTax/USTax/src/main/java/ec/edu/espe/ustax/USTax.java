package ec.edu.espe.tax;

/**
 * Singleton class to handle US Tax computation
 */
public class USTax {
    private static USTax instance;
    private float taxRate;

    // Private constructor to prevent external instantiation
    private USTax() {
        taxRate = 0.12F; // Default tax rate 12%
    }

    // Static method to get the single instance
    public static USTax getInstance() {
        if (instance == null) {
            instance = new USTax();
        }
        return instance;
    }

    // Method to compute tax based on a price
    public float computeTax(float amount) {
        return amount * taxRate;
    }

    // Optional method to update the tax rate
    public void setTaxRate(float newRate) {
        this.taxRate = newRate;
    }

    public float getTaxRate() {
        return taxRate;
    }
}
