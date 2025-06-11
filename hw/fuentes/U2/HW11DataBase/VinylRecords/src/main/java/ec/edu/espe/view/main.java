package ec.edu.espe.view;

import ec.edu.espe.model.VinylRecord;
import com.google.gson.Gson;
import com.mongodb.client.*;
import org.bson.Document;

import java.util.Scanner;
/**
 *
 * @author jorge
 */

public class main {
    public static void main(String[] args) {
        String uri = "mongodb+srv://Jorge:Jorge@cluster0.ny8bieg.mongodb.net/"; 
        MongoClient mongoClient = MongoClients.create(uri);
        MongoDatabase database = mongoClient.getDatabase("VinylDB");
        MongoCollection<Document> collection = database.getCollection("Records");

        Scanner scanner = new Scanner(System.in);
        Gson gson = new Gson();

        System.out.println("1. Registrar nuevo VinylRecord");
        System.out.println("2. Leer todos los VinylRecords");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        if (opcion == 1) {
            System.out.print("Title: ");
            String title = scanner.nextLine();
            System.out.print("Artist: ");
            String artist = scanner.nextLine();
            System.out.print("Year: ");
            int year = scanner.nextInt(); scanner.nextLine();
            System.out.print("Gender: ");
            String gender = scanner.nextLine();
            System.out.print("Duration: ");
            String duration = scanner.nextLine();
            System.out.print("Label: ");
            String label = scanner.nextLine();
            System.out.print("Country: ");
            String country = scanner.nextLine();
            System.out.print("Color: ");
            String color = scanner.nextLine();
            System.out.print("Track Count: ");
            int trackCount = scanner.nextInt();
            System.out.print("Limited Edition (Y/N): ");
            String limitedEdition = scanner.nextLine();

            VinylRecord record = new VinylRecord(title, artist, year, gender, duration,label, country, color, trackCount, limitedEdition);

            String json = gson.toJson(record);
            Document doc = Document.parse(json);
            collection.insertOne(doc);
            System.out.println("✅ Registro insertado con éxito.");
        } else if (opcion == 2) {
            MongoCursor<Document> cursor = collection.find().iterator();
            while (cursor.hasNext()) {
                Document doc = cursor.next();
                VinylRecord record = gson.fromJson(doc.toJson(), VinylRecord.class);
                System.out.println(record);
            }
        }

        mongoClient.close();
    }
}
