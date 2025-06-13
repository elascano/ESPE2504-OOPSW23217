package ec.edu.espe.model;
/**
 *
 * @author jorge
 */
public class VinylRecord {
    private String tittle;
    private String artist;
    private int year;
    private String gender;
    private String duration;
    private String label;
    private String country;
    private String color;
    private int trackCount;
    private String limitedEdition;

    public VinylRecord(String tittle, String artist, int year, String gender, String duration, String label, String country, String color, int trackCount, String limitedEdition) {
        this.tittle = tittle;
        this.artist = artist;
        this.year = year;
        this.gender = gender;
        this.duration = duration;
        this.label = label;
        this.country = country;
        this.color = color;
        this.trackCount = trackCount;
        this.limitedEdition = limitedEdition;
    }
    
    @Override
    public String toString(){
        return "VinylRecord{" + "title='" + tittle + '\'' + ", artist='" + artist + '\'' + ", year=" + year + ", gender='" + gender + '\'' + ", duration='" + duration + '\'' + ", label='" + label + '\'' + ", country='" + country + '\'' + ", color='" + color + '\'' + ", trackCount=" + trackCount + ", limitedEdition='" + limitedEdition + '\'' + '}';
    }
    
}
