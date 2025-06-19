package ec.edu.espe.microphonecrude;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.conversions.Bson;
import java.util.Scanner;

/**
 *
 * @author Micaela Jacome DESKTOP-46VMNHU ESPE
 */

public class MicrophoneCRUD {
    private static final String CONNECTION_STRING = "mongodb+srv://Micaela:Micaela@cluster0.7ny5ynf.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
    private static final String DATABASE_NAME = "Microphone";
    private static final String COLLECTION_NAME = "microphone";
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        
        while (!exit) {
            printMenu();
            int option = getIntInput("Select an option");
            
            switch (option) {
                case 1:
                    createMicrophone();
                    break;
                case 2:
                    readMicrophones();
                    break;
                case 3:
                    updateMicrophone();
                    break;
                case 4:
                    deleteMicrophone();
                    break;
                case 5:
                    calculateDiscount();
                    break;
                case 6:
                    exit = true;
                    System.out.println("Exiting system...");
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n=== MICROPHONE MANAGEMENT SYSTEM ===");
        System.out.println("1. Add microphone");
        System.out.println("2. List all microphones");
        System.out.println("3. Update microphone");
        System.out.println("4. Delete microphone");
        System.out.println("5. Calculate discount");
        System.out.println("6. Exit");
    }

    private static void createMicrophone() {
        System.out.println("\n--- NEW MICROPHONE ---");
        
        Document microphone = new Document();
        microphone.append("id", getStringInput("ID"));
        microphone.append("brand", getStringInput("Brand"));
        microphone.append("model", getStringInput("Model"));
        microphone.append("type", getStringInput("Type"));
        microphone.append("price", getValidatedPriceInput("Price"));
        
        try (MongoClient client = MongoClients.create(CONNECTION_STRING)) {
            getCollection(client).insertOne(microphone);
            System.out.println("Microphone added successfully!");
        } catch (Exception e) {
            System.err.println("Error connecting to MongoDB: " + e.getMessage());
        }
    }

    private static void readMicrophones() {
        try (MongoClient client = MongoClients.create(CONNECTION_STRING)) {
            System.out.println("\n--- MICROPHONE LIST ---");
            
            for (Document doc : getCollection(client).find()) {
                printMicrophoneDetails(doc);
                System.out.println("-----------------------------");
            }
        } catch (Exception e) {
            System.err.println("Error reading data: " + e.getMessage());
        }
    }

    private static void updateMicrophone() {
        System.out.println("\n--- UPDATE MICROPHONE ---");
        String id = getStringInput("Microphone ID to update");
        
        try (MongoClient client = MongoClients.create(CONNECTION_STRING)) {
            Bson filter = Filters.eq("id", id);
            Document existing = getCollection(client).find(filter).first();
            
            if (existing == null) {
                System.out.println("Microphone with ID " + id + " not found");
                return;
            }
            
            System.out.println("\nCurrent details:");
            printMicrophoneDetails(existing);
            
            Bson updates = Updates.combine(
                Updates.set("brand", getStringInput("New brand (" + existing.getString("brand") + ")")),
                Updates.set("price", getValidatedPriceInput("New price (" + getPriceAsDouble(existing) + ")"))
            );
            
            getCollection(client).updateOne(filter, updates);
            System.out.println("Microphone updated successfully!");
        } catch (Exception e) {
            System.err.println("Error updating: " + e.getMessage());
        }
    }

    private static void deleteMicrophone() {
        System.out.println("\n--- DELETE MICROPHONE ---");
        String id = getStringInput("Microphone ID to delete");
        
        try (MongoClient client = MongoClients.create(CONNECTION_STRING)) {
            long deletedCount = getCollection(client).deleteOne(Filters.eq("id", id)).getDeletedCount();
            
            if (deletedCount > 0) {
                System.out.println("Microphone deleted successfully!");
            } else {
                System.out.println("Microphone with ID " + id + " not found");
            }
        } catch (Exception e) {
            System.err.println("Error deleting: " + e.getMessage());
        }
    }

    private static void calculateDiscount() {
        System.out.println("\n--- CALCULATE DISCOUNT ---");
        String id = getStringInput("Microphone ID");
        double discount = getValidatedDiscountInput("Discount percentage");
        
        try (MongoClient client = MongoClients.create(CONNECTION_STRING)) {
            Document doc = getCollection(client).find(Filters.eq("id", id)).first();
            
            if (doc == null) {
                System.out.println("Microphone not found");
                return;
            }
            
            double price = getPriceAsDouble(doc);
            double finalPrice = price * (1 - discount/100);
            
            System.out.printf("\nOriginal price: $%.2f", price);
            System.out.printf("\nDiscount (%.0f%%): $%.2f", discount, price * discount/100);
            System.out.printf("\nFinal price: $%.2f\n", finalPrice);
        } catch (Exception e) {
            System.err.println("Error calculating: " + e.getMessage());
        }
    }

    // Helper methods
    private static MongoCollection<Document> getCollection(MongoClient client) {
        return client.getDatabase(DATABASE_NAME).getCollection(COLLECTION_NAME);
    }

    private static void printMicrophoneDetails(Document doc) {
        System.out.println("\nID: " + doc.getString("id"));
        System.out.println("Brand: " + doc.getString("brand"));
        System.out.println("Model: " + doc.getString("model"));
        System.out.println("Type: " + doc.getString("type"));
        System.out.printf("Price: $%.2f%n", getPriceAsDouble(doc));
    }

    private static double getPriceAsDouble(Document doc) {
        try {
            if (doc.get("price") instanceof String) {
                return Double.parseDouble(doc.getString("price"));
            }
            return doc.getDouble("price");
        } catch (Exception e) {
            System.err.println("Error reading price value: " + e.getMessage());
            return 0.0;
        }
    }

    private static String getStringInput(String prompt) {
        System.out.print(prompt + ": ");
        return scanner.nextLine();
    }

    private static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt + ": ");
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer");
            }
        }
    }

    private static double getValidatedPriceInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt + ": ");
                String input = scanner.nextLine();
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid price (e.g. 99.99)");
            }
        }
    }

    private static double getValidatedDiscountInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt + ": ");
                double discount = Double.parseDouble(scanner.nextLine());
                if (discount >= 0 && discount <= 100) {
                    return discount;
                }
                System.out.println("Please enter a value between 0 and 100");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number");
            }
        }
    }
}