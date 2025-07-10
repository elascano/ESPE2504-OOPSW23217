package ec.edu.espe.vehicle.model;

/**
 *
 * @author PC
 */
public class Vehicle {
    private String brand;
    private String model;
    private boolean isDigital;    
    private int numPlaca;
    private float Price;
    private String serialNumber;

    @Override
    public String toString() {
        return "SoundMixer{" + "brand=" + brand + ", model=" + model + ", isDigital=" + isDigital + ", numChannels=" + numPlaca + ", Price=" + Price + ", serialNumber=" + serialNumber + '}';
    }

    public Vehicle(String brand, String model, boolean isDigital, int numChannels, float Price, String serialNumber) {
        this.brand = brand;
        this.model = model;
        this.isDigital = isDigital;
        this.numPlaca = numChannels;
        this.Price = Price;
        this.serialNumber = serialNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean isIsDigital() {
        return isDigital;
    }

    public void setIsDigital(boolean isDigital) {
        this.isDigital = isDigital;
    }

    public int getNumChannels() {
        return numPlaca;
    }

    public void setNumChannels(int numChannels) {
        this.numPlaca = numChannels;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float Price) {
        this.Price = Price;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

}
