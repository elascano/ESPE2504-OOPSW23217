/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.flashdrivedb;

/**
 *
 * @author jgyc_
 */
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FlashDriveDB {

    private static final String CONNECTION_STRING = "mongodb+srv://jgyanez2:<jgyanez2>@cluster0.bdnssw7.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
    private static final String DATABASE_NAME = "WarGame";
    private static final String COLLECTION_NAME = "flashDrive";
    private static final String OUTPUT_FILE = "flashdrive.json";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MongoClient mongoClient = null;

        try {
            mongoClient = MongoClients.create(CONNECTION_STRING);
            MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
            MongoCollection<Document> collection = database.getCollection(COLLECTION_NAME);

            Document flashDriveDocument = readFlashDriveData(scanner);
            saveJsonToFile(flashDriveDocument, OUTPUT_FILE);
            insertFlashDriveToDatabase(flashDriveDocument, collection);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
            if (mongoClient != null) {
                mongoClient.close();
            }
        }
    }

    private static Document readFlashDriveData(Scanner scanner) {
        System.out.print("Brand: ");
        String brand = scanner.nextLine();

        System.out.print("Capacity (GB): ");
        int capacityGB = Integer.parseInt(scanner.nextLine());

        System.out.print("Price: ");
        double price = Double.parseDouble(scanner.nextLine());

        System.out.print("Color: ");
        String color = scanner.nextLine();

        System.out.print("USB Type: ");
        String usbType = scanner.nextLine();

        System.out.print("Stock: ");
        int stock = Integer.parseInt(scanner.nextLine());

        System.out.print("Warranty (months): ");
        int warrantyMonths = Integer.parseInt(scanner.nextLine());

        System.out.print("Discount Percentage: ");
        double discountPercentage = Double.parseDouble(scanner.nextLine());

        double finalPrice = price - (price * discountPercentage / 100);

        return new Document("brand", brand)
                .append("capacityGB", capacityGB)
                .append("price", price)
                .append("color", color)
                .append("usbType", usbType)
                .append("stock", stock)
                .append("warrantyMonths", warrantyMonths)
                .append("discountPercentage", discountPercentage)
                .append("finalPrice", finalPrice);
    }

    private static void saveJsonToFile(Document document, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(document.toJson());
            System.out.println("JSON saved to " + filename);
        } catch (IOException e) {
            System.out.println("Failed to save JSON: " + e.getMessage());
        }
    }

    private static void insertFlashDriveToDatabase(Document document, MongoCollection<Document> collection) {
        collection.insertOne(document);
        System.out.println("Flash drive data inserted into MongoDB.");
    }
}
