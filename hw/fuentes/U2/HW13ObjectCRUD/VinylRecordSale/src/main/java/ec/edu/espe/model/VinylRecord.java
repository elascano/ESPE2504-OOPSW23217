
package ec.edu.espe.model;

/**
 *
 * @author jorge
 */
public class VinylRecord {
    private String title;
    private String artist;
    private int year;
    private String genre;
    private String duration;
    private String label;
    private String country;
    private String color;
    private float basePrice;
    private boolean limitedEdition;
    private float priceAdjustment;
    private float finalPrice;

    public VinylRecord(String title, String artist, int year, String genre, String duration, String label, String country, String color, float basePrice, boolean limitedEdition) {
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.genre = genre;
        this.duration = duration;
        this.label = label;
        this.country = country;
        this.color = color;
        this.basePrice = basePrice;
        this.limitedEdition = limitedEdition;
        this.priceAdjustment = calculatePriceAdjustment();
        this.finalPrice = basePrice + this.priceAdjustment;
    }
    
    private float calculatePriceAdjustment() {
        float adjustment = 0.0f;
        if (limitedEdition) {
            adjustment += basePrice * 0.5f;
        }
        if (!color.equals("black")) {
            adjustment += 10.0f;
        }
        return adjustment;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public String getDuration() {
        return duration;
    }

    public String getLabel() {
        return label;
    }

    public String getCountry() {
        return country;
    }

    public String getColor() {
        return color;
    }

    public float getBasePrice() {
        return basePrice;
    }

    public boolean isLimitedEdition() {
        return limitedEdition;
    }

    public float getPriceAdjustment() {
        return priceAdjustment;
    }

    public float getFinalPrice() {
        return finalPrice;
    }
    
    
    
}
