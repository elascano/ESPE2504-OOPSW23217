
package ec.edu.espe.view;

import ec.edu.espe.model.VinylRecord;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Jorge Fuentes
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Title: ");
        String title = scanner.nextLine();

        System.out.print("Artist: ");
        String artist = scanner.nextLine();

        System.out.print("Year: ");
        int year = Integer.parseInt(scanner.nextLine());

        System.out.print("Genre: ");
        String genre = scanner.nextLine();

        System.out.print("Duration: ");
        String duration = scanner.nextLine();

        System.out.print("Record Label: ");
        String label = scanner.nextLine();

        System.out.print("Country: ");
        String country = scanner.nextLine();

        System.out.print("Format: ");
        String format = scanner.nextLine();

        System.out.print("Track Count: ");
        int trackCount = Integer.parseInt(scanner.nextLine());

        System.out.print("Is it a limited edition? (y/n): ");
        boolean limitedEdition = scanner.nextLine().trim().equalsIgnoreCase("y");

        VinylRecord record = new VinylRecord(title, artist, year, genre, duration,
                label, country, format, trackCount, limitedEdition);

        try (FileWriter writer = new FileWriter("vinyl_record.json")) {
            writer.write(record.toJson());
            System.out.println("✅ Record saved to vinyl_record.json");
        } catch (IOException e) {
            System.out.println("❌ Error saving file: " + e.getMessage());
        }

        scanner.close();
    }
    
}
