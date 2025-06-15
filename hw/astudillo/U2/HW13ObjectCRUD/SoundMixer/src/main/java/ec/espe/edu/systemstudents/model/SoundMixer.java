package ec.espe.edu.systemstudents.model;

public class SoundMixer {
    private String brand;
    private String model;
    private boolean digital;
    private int channels;
    private float priceUSD;
    private String serial;

    public SoundMixer(String brand, String model, boolean digital, int channels, float priceUSD, String serial) {
        this.brand = brand;
        this.model = model;
        this.digital = digital;
        this.channels = channels;
        this.priceUSD = priceUSD;
        this.serial = serial;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public boolean isDigital() {
        return digital;
    }

    public int getChannels() {
        return channels;
    }

    public float getPriceUSD() {
        return priceUSD;
    }

    public String getSerial() {
        return serial;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setDigital(boolean digital) {
        this.digital = digital;
    }

    public void setChannels(int channels) {
        this.channels = channels;
    }

    public void setPriceUSD(float priceUSD) {
        this.priceUSD = priceUSD;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    @Override
    public String toString() {
        return brand + " " + model + " " + (digital ? "Digital" : "Analógico") + " " + channels + "ch $" + priceUSD + " Serial: " + serial;
    }
}