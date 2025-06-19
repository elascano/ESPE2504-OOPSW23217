package ec.edu.espe.cablecrud.model;

/**
 *
 * @author Tammy Caizapanta SoftCrafters DCCO ESPE
 */

public class CableCRUD {

    private String id;
    private String type;
    private double lengthMeters;
    private double pricePerMeter;
    private int stockQuantity;

    public CableCRUD(String id, String type, double lengthMeters, double pricePerMeter, int stockQuantity) {
        this.id = id;
        this.type = type;
        this.lengthMeters = lengthMeters;
        this.pricePerMeter = pricePerMeter;
        this.stockQuantity = stockQuantity;
    }

    public String getId() { return id; }
    public String getType() { return type; }
    public double getLengthMeters() { return lengthMeters; }
    public double getPricePerMeter() { return pricePerMeter; }
    public int getStockQuantity() { return stockQuantity; }

    public double calculateTotalPrice() {
        return lengthMeters * pricePerMeter;
    }
}