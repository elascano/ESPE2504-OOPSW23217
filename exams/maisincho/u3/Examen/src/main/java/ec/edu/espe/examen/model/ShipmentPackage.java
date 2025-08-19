package ec.edu.espe.examen.model;

public abstract class ShipmentPackage {
    protected double weightKg;
    protected double declaredValue;
    protected String description;
    protected String trackingCode;
    protected boolean fragile;
    protected Discount discountStrategy;
    protected double originalPrice;
    protected double finalPrice;

    public ShipmentPackage(double weightKg, double declaredValue, String description,
                           String trackingCode, boolean fragile, Discount discountStrategy) {
        this.weightKg = weightKg;
        this.declaredValue = declaredValue;
        this.description = description;
        this.trackingCode = trackingCode;
        this.fragile = fragile;
        this.discountStrategy = discountStrategy;
    }

    public final void processShipment() {
        registerReception();
        packageContent();
        transport();
        calculatePrice();
        applyDiscount();
    }

    protected void registerReception() {
        System.out.println("Registro de recepción: " + trackingCode);
    }

    protected abstract void packageContent();

    protected void transport() {
        System.out.println("Transportando paquete: " + trackingCode + " (Frágil: " + fragile + ")");
    }

    protected abstract void calculatePrice();

    protected void applyDiscount() {
        if (discountStrategy != null) {
            finalPrice = discountStrategy.apply(originalPrice);
        } else {
            finalPrice = originalPrice;
        }
    }

    public double getWeightKg() { return weightKg; }
    public double getDeclaredValue() { return declaredValue; }
    public String getDescription() { return description; }
    public String getTrackingCode() { return trackingCode; }
    public boolean isFragile() { return fragile; }
    public double getOriginalPrice() { return originalPrice; }
    public double getFinalPrice() { return finalPrice; }
}


