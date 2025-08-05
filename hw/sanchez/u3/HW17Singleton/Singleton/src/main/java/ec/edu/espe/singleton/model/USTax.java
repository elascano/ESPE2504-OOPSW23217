package ec.edu.espe.singleton.model;

public class USTax {
    
    private static USTax instance;
    private static final double TAXRATE = 0.085;
    
    private USTax() {}
    
    public static USTax getInstance() {
        if (instance == null) {
            instance = new USTax();
        }
        return instance;
    }
    
    public double getSalesTotal(double saleAmount) {
        return saleAmount + (saleAmount * TAXRATE);
    }
    
    public double getTaxAmount(double saleAmount) {
        return saleAmount * TAXRATE;
    }
    
    public double getTaxRate() {
        return TAXRATE;
    }
}
