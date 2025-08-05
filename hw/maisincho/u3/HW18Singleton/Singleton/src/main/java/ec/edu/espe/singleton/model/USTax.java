
package ec.edu.espe.singleton.model;

/**
 *
 * @author Isaac Maisincho Crafters_Market DCCO ESPE
 */
public class USTax {

    private static USTax instance;
    private float taxPercentage;

    public USTax(float taxPercentage) {
        this.taxPercentage = taxPercentage;
    }

    public static USTax getInstance() {
        if (instance == null) {
            instance = new USTax(0.2F);
        }
        return instance;

    }

    public static void setInstance(USTax newInstance) {
        if (newInstance != null) {
            instance = newInstance;
        } else {
            System.out.println("Cannot set null instance ");
        }
    }

    public float getTaxPercentage() {
        return taxPercentage;
    }

    public void setTaxPercentage(float taxPercentage) {
        this.taxPercentage = taxPercentage;
    }

}
