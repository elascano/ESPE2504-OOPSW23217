
package com.mycompany.database;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import java.util.Scanner;


/**
 *
 * @author Isaac Maisincho Crafters_Market DCCO ESPE
 */
public class MongoDataBase {
    static String connectionString = "mongodb+srv://isaac:isaac@cluster0.xaitfht.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
    
    public static void insertarLaptop() {
         Scanner scanner = new Scanner(System.in);

        System.out.print("laptop id: ");
        String id = scanner.nextLine();

        System.out.print("Name Laptop: ");
        String name = scanner.nextLine();
        
        System.out.println("Processor");
        String processor=scanner.nextLine();
        
        System.out.print("enter the RAM ");
        int ram = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("enter color laptop: ");
        String color = scanner.nextLine();

        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            MongoDatabase database = mongoClient.getDatabase("dbmongo");
            MongoCollection<Document> collection = database.getCollection("laptop");

            Document document = new Document("id", id)
                    .append("name", name)
                    .append("processor", processor)
                    .append("Ram", ram)
                    .append("color", color);

           
            collection.insertOne(document);

            System.out.println("correct insertion.");
        } catch (Exception e) {
            System.err.println("Error conection with MongoDB: " + e.getMessage());
        }
    }

    
    public static void mostrarLaptop() {
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            MongoDatabase database = mongoClient.getDatabase("dbmongo");
            MongoCollection<Document> collection = database.getCollection("laptop");

            System.out.println("\nSaved in the database:");

          
            for (Document doc : collection.find()) {
                System.out.println(doc.toJson());
            }
        } catch (Exception e) {
            System.err.println("Error conection with MongoDB: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
      
        int opcion;
        do {
            
            System.out.println("\n Menu:");
            System.out.println("1. Insert Laptop ");
            System.out.println("2. Show Laptop");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");
            opcion = scanner.nextInt();

           
            scanner.nextLine();

            
            switch (opcion) {
                case 1:
                    insertarLaptop();
                    break;
                case 2:
                    mostrarLaptop();
                    break;
                case 0:
                    System.out.println("Exit...");
                    break;
                default:
                    System.out.println("Invalid option, please enter a valid option..");
            }
        } while (opcion != 0);


        scanner.close();
    }
}