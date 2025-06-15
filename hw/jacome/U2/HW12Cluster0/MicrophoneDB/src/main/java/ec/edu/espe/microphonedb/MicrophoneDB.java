package ec.edu.espe.microphonedb;

/**
 *
 * @author Micaela Jacome DESKTOP-46VMNHU ESPE
 */



import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import java.util.Scanner;

public class MicrophoneDB {
    static String connectionString = "mongodb+srv://Micaela:Micaela@cluster0.7ny5ynf.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
    
    public static void insertMicrophone() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Microphone ID: ");
        String id = scanner.nextLine();

        System.out.print("Brand: ");
        String brand = scanner.nextLine();
        
        System.out.print("Model: ");
        String model = scanner.nextLine();
        
        System.out.print("Type: ");
        String type = scanner.nextLine();
        
        System.out.print("Color: ");
        String color = scanner.nextLine();

        System.out.print("Connection: ");
        String connection = scanner.nextLine();

        System.out.print("Frequency: ");
        String frequency = scanner.nextLine();

        System.out.print("Sensitivity: ");
        String sensitivity = scanner.nextLine();

        System.out.print("Impedance: ");
        String impedance = scanner.nextLine();

        System.out.print("Price: ");
        String price = scanner.nextLine();

        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            MongoDatabase database = mongoClient.getDatabase("Microphone");
            MongoCollection<Document> collection = database.getCollection("microphone");

            Document document = new Document("id", id)
                    .append("brand", brand)
                    .append("model", model)
                    .append("type", type)
                    .append("color", color)
                    .append("connection", connection)
                    .append("frequency", frequency)
                    .append("sensitivity", sensitivity)
                    .append("impedance", impedance)
                    .append("price", price);

            collection.insertOne(document);
            System.out.println("Microphone added successfully!");
        } catch (Exception e) {
            System.err.println("Error connecting to MongoDB: " + e.getMessage());
        }
    }

    public static void showMicrophones() {
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            MongoDatabase database = mongoClient.getDatabase("Microphone");
            MongoCollection<Document> collection = database.getCollection("microphone");

            System.out.println("\nMicrophones in database:");

            for (Document doc : collection.find()) {
                System.out.println("ID: " + doc.getString("id"));
                System.out.println("Brand: " + doc.getString("brand"));
                System.out.println("Model: " + doc.getString("model"));
                System.out.println("Type: " + doc.getString("type"));
                System.out.println("Color: " + doc.getString("color"));
                System.out.println("Connection: " + doc.getString("connection"));
                System.out.println("Frequency: " + doc.getString("frequency"));
                System.out.println("Sensitivity: " + doc.getString("sensitivity"));
                System.out.println("Impedance: " + doc.getString("impedance"));
                System.out.println("Price: " + doc.getString("price"));
                System.out.println("-----------------------------");
            }
        } catch (Exception e) {
            System.err.println("Error connecting to MongoDB: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
      
        int option;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add Microphone");
            System.out.println("2. Show Microphones");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    insertMicrophone();
                    break;
                case 2:
                    showMicrophones();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        } while (option != 0);

        scanner.close();
    }
}