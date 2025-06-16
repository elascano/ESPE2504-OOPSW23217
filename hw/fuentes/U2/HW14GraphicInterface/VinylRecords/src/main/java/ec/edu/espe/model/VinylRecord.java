package ec.edu.espe.model;

/**
 *
 * @author jorge
 */
public class VinylRecord {
    private String title;
    private String artist;
    private int year;
    private String gender;
    private String duration;
    private String label;
    private String country;
    private String color;
    private float price;
    private String limitedEdition;

    public VinylRecord(String title, String artist, int year, String gender, String duration, String label, String country, String color, float price, String limitedEdition) {
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.gender = gender;
        this.duration = duration;
        this.label = label;
        this.country = country;
        this.color = color;
        this.price = price;
        this.limitedEdition = limitedEdition;
    }

 
    

    public String getTittle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getYear() {
        return year;
    }

    public String getGender() {
        return gender;
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

    public float getPrice() {
        return price;
    }

    public String getLimitedEdition() {
        return limitedEdition;
    }

    public void setTittle(String tittle) {
        this.title = tittle;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setLimitedEdition(String limitedEdition) {
        this.limitedEdition = limitedEdition;
    }
    
   
    
}
