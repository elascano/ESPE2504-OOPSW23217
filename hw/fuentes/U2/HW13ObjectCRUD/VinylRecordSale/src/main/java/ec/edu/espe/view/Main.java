
package ec.edu.espe.view;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import ec.edu.espe.model.VinylRecord;
import java.util.Scanner;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author jorge
 */
public class Main {
    public static void main(String[] args){
        MongoClient mongoClient = MongoClients.create("mongodb+srv://Jorge:Jorge@cluster0.ny8bieg.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0");
        MongoDatabase database = mongoClient.getDatabase("VinylSale");
        MongoCollection<Document> collection = database.getCollection("records");
        Scanner scanner = new Scanner(System.in);
        int option;
        do{
            System.out.println("\n=== VINYL RECORD MENU ===");
            System.out.println("1. Register a vinyl record");
            System.out.println("2. Show all records");
            System.out.println("3. Search by title");
            System.out.println("4. Delete by title");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            option = Integer.parseInt(scanner.nextLine());
            
            switch(option) {
                case 1:
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
                    System.out.print("Label: ");
                    String label = scanner.nextLine();
                    System.out.print("Country: ");
                    String country = scanner.nextLine();
                    System.out.print("Color: ");
                    String color = scanner.nextLine();
                    System.out.print("Base price: ");
                    float basePrice = Float.parseFloat(scanner.nextLine());
                    System.out.print("Limited edition? (Y/N): ");
                    String limitedInput = scanner.nextLine().trim().toUpperCase();
                    boolean limitedEdition = limitedInput.equals("Y");
                    
                    VinylRecord record = new VinylRecord(title, artist, year, genre, duration, label, country, color, basePrice, limitedEdition);

                    Document doc = new Document("title", record.getTitle())
                            .append("artist", record.getArtist())
                            .append("year", record.getYear())
                            .append("genre", record.getGenre())
                            .append("duration", record.getDuration())
                            .append("label", record.getLabel())
                            .append("country", record.getCountry())
                            .append("color", record.getColor())
                            .append("basePrice", record.getBasePrice())
                            .append("limitedEdition", record.isLimitedEdition())
                            .append("priceAdjustment", record.getPriceAdjustment())
                            .append("finalPrice", record.getFinalPrice());

                    collection.insertOne(doc);
                    System.out.println("Vinyl record saved successfully.");
                    break;
                    
                case 2:
                    FindIterable<Document> allDocs = collection.find();
                    System.out.println("\n--- ALL VINYL RECORDS ---");
                    for (Document d : allDocs) {
                        System.out.println("----------------------------");
                        System.out.println("Title: " + d.getString("title"));
                        System.out.println("Artist: " + d.getString("artist"));
                        System.out.println("Year: " + d.getInteger("year"));
                        System.out.println("Genre: " + d.getString("genre"));
                        System.out.println("Duration: " + d.getString("duration"));
                        System.out.println("Label: " + d.getString("label"));
                        System.out.println("Country: " + d.getString("country"));
                        System.out.println("Color: " + d.getString("color"));
                        System.out.println("Base Price: $" + d.getDouble("basePrice"));
                        System.out.println("Limited Edition: " + d.getBoolean("limitedEdition"));
                        System.out.println("Price Adjustment: $" + d.getDouble("priceAdjustment"));
                        System.out.println("Final Price: $" + d.getDouble("finalPrice"));
                    }
                    break;

                case 3:
                    System.out.print("Enter title to search: ");
                    String searchTitle = scanner.nextLine();
                    Document found = collection.find(Filters.eq("title", searchTitle)).first();
                    if (found != null) {
                        System.out.println("Record found:");
                        System.out.println("Title: " + found.getString("title"));
                        System.out.println("Artist: " + found.getString("artist"));
                        System.out.println("Year: " + found.getInteger("year"));
                        System.out.println("Genre: " + found.getString("genre"));
                        System.out.println("Duration: " + found.getString("duration"));
                        System.out.println("Label: " + found.getString("label"));
                        System.out.println("Country: " + found.getString("country"));
                        System.out.println("Color: " + found.getString("color"));
                        System.out.println("Base Price: $" + found.getDouble("basePrice"));
                        System.out.println("Limited Edition: " + found.getBoolean("limitedEdition"));
                        System.out.println("Price Adjustment: $" + found.getDouble("priceAdjustment"));
                        System.out.println("Final Price: $" + found.getDouble("finalPrice"));
                    } else {
                        System.out.println("No record found with that title.");
                    }
                    break;

                case 4:
                    System.out.print("Enter title to delete: ");
                    String deleteTitle = scanner.nextLine();
                    Bson filter = Filters.eq("title", deleteTitle);
                    if (collection.deleteOne(filter).getDeletedCount() > 0) {
                        System.out.println("Record deleted successfully.");
                    } else {
                        System.out.println("No record found to delete.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    break;
                    
                default:
                    System.out.println("Invalid option. Please try again.");
        }
    }while(option !=5);
    mongoClient.close();
    }
}
