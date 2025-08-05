package ec.edu.espe.cellphonecrud.model;

/**
 *
 * @author Bonilla David SoftCrafters
 */
public class Cellphone {

    private int id;
    private int width;
    private int height;
    private String type;
    private double priceFinal;

    public static double calculateManufacturingCost(String type) {

        double baseCost = 100.50f;
        double priceFinal;
        String phoneType = type.toLowerCase();

        switch (phoneType) {
            case "smartphone":
                priceFinal = baseCost + 55.10f;
                break;
            case "feature phone":
                priceFinal = baseCost + 20.50f;
                break;
            case "iphone":
                priceFinal = baseCost + 120.50f;
                break;
            case "apple":
                priceFinal = baseCost + 110.30f;
                break;
            case "android":
                priceFinal = baseCost + 60.12f;
                break;
            case "foldable":
                priceFinal = baseCost + 150.70f;
                break;
            case "gaming phone":
                priceFinal = baseCost + 130.12f;
                break;
            case "rugged phone":
                priceFinal = baseCost + 70.90f;
                break;
            case "business phone":
                priceFinal = baseCost + 80.99f;
                break;
            default:
                priceFinal = baseCost + 29.99f;
                break;
        }
        
        return round(priceFinal);
    }

    public static double round(double numero) {
        return Math.round(numero * 10.0) / 10.0;
    }

    public Cellphone(int id, int width, int height, String type, double priceFinal) {
        this.id = id;
        this.width = width;
        this.height = height;
        this.type = type;
        this.priceFinal = priceFinal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPriceFinal() {
        return priceFinal;
    }

    public void setPriceFinal(double priceFinal) {
        this.priceFinal = priceFinal;
    }

}
