package com.mycompany.scissorsdb;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ScissorsDB {

    private static final String CONNECTION_STRING = "mongodb+srv://mjunda1:MateoUndaJM05@cluster0.7yle2fx.mongodb.net/";
    private static final String DATABASE_NAME = "WarGame";
    private static final String COLLECTION_NAME = "Scissors";
    private static final String OUTPUT_FILE = "scissors.json";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MongoClient mongoClient = null;

        try {
            mongoClient = MongoClients.create(CONNECTION_STRING);
            MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
            MongoCollection<Document> collection = database.getCollection(COLLECTION_NAME);

            Document scissorsDocument = readScissorData(scanner);
            saveJsonToFile(scissorsDocument, OUTPUT_FILE);
            insertScissorToDatabase(scissorsDocument, collection);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
            if (mongoClient != null) {
                mongoClient.close();
            }
        }
    }

    private static Document readScissorData(Scanner scanner) {
        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Handedness (right-handed / left-handed): ");
        String handedness = scanner.nextLine();

        System.out.print("Color: ");
        String color = scanner.nextLine();

        System.out.print("Length (cm): ");
        double length = Double.parseDouble(scanner.nextLine());

        System.out.print("Price: ");
        double price = Double.parseDouble(scanner.nextLine());

        return new Document("id", id)
                .append("handedness", handedness)
                .append("color", color)
                .append("length", length)
                .append("price", price);
    }

    private static void saveJsonToFile(Document document, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(document.toJson());
            System.out.println("JSON saved to " + filename);
        } catch (IOException e) {
            System.out.println("Failed to save JSON: " + e.getMessage());
        }
    }

    private static void insertScissorToDatabase(Document document, MongoCollection<Document> collection) {
        collection.insertOne(document);
        System.out.println("Scissor data inserted into MongoDB.");
    }
}
