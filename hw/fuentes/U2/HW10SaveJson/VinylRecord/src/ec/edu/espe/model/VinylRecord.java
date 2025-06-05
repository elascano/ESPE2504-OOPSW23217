
package ec.edu.espe.model;

/**
 *
 * @author Jorge Fuentes
 */
public class VinylRecord {
    String title;
    String artist;
    int year;
    String gener;
    String duration;
    String label;
    String country;
    String format;
    int trackCount;
    boolean limitedEdition;

    public VinylRecord(String title, String artist, int year, String genre, String duration,
                       String label, String country, String format, int trackCount, boolean limitedEdition) {
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.gener = genre;
        this.duration = duration;
        this.label = label;
        this.country = country;
        this.format = format;
        this.trackCount = trackCount;
        this.limitedEdition = limitedEdition;
    }

    public String toJson() {
        return String.format("""
        {
            "Insert title": "%s",
            "Insert artist": "%s",
            "Insert year": %d,
            "Insert gener": "%s",
            "Insert duration": "%s",
            "Insert label": "%s",
            "Insert country": "%s",
            "Insert format": "%s",
            "Insert trackCount": %d,
            "Insert limitedEdition": %s
        }
        """, title, artist, year, gener, duration, label, country, format, trackCount, limitedEdition);
    }
}
