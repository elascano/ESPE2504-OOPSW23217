package com.mycompany.dbconnection;

import com.google.gson.Gson;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Scanner;

/**
 *
 * @author Tammy Caizapanta SoftCrafters DCCO ESPE
 */
public class MongoDB {
    
    static String connectionString = "mongodb+srv://tacaizapanta:tacaizapanta@cluster0.xaitfht.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";

    public static void insertCable() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Cable ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Brand: ");
        String brand = scanner.nextLine();

        System.out.print("Length: ");
        int lenght = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Type (e.g., HDMI, USB-C): ");
        String type = scanner.nextLine();

        Cable cable = new Cable(id, brand, lenght, type);

        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            MongoDatabase database = mongoClient.getDatabase("dbmongo");
            MongoCollection<Document> collection = database.getCollection("cable");

            Gson gson = new Gson();
            String json = gson.toJson(cable);
            Document document = Document.parse(json);

            collection.insertOne(document);
            System.out.println("Cable inserted successfully.");
        } catch (Exception e) {
            System.err.println("Error connecting with MongoDB: " + e.getMessage());
        }
    }

    public static void showCable() {
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            MongoDatabase database = mongoClient.getDatabase("dbmongo");
            MongoCollection<Document> collection = database.getCollection("cable");

            System.out.println("\nCables in database:");
            Gson gson = new Gson();

            for (Document doc : collection.find()) {
                Cable cable = gson.fromJson(doc.toJson(), Cable.class);
                System.out.println(cable);
            }
        } catch (Exception e) {
            System.err.println("Error connecting with MongoDB: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Insert Cable");
            System.out.println("2. Show Cables");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    insertarCable();
                    break;
                case 2:
                    mostrarCables();
                    break;
                case 0:
                    System.out.println("Exit...");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}
