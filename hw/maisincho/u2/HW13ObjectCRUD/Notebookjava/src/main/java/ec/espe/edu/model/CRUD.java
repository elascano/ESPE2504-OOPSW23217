package ec.espe.edu.model;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static ec.espe.edu.model.Operation.comprarNotebook;

import org.bson.Document;

import java.util.Scanner;

/**
 *
 * @author Isaac Maisincho Crafters_Market DCCO ESPE
 */
public class CRUD {

    static Scanner scanner = new Scanner(System.in);
    static String connectionString = "mongodb+srv://isaac:isaac@cluster0.xaitfht.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";

    public static void insertarNotebook() {

        System.out.print("Notebook id: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("stock :");
        int stock = scanner.nextInt();
        scanner.nextLine();

        System.out.print("  Price: ");

        String priceStr = scanner.nextLine().replace(',', '.');
        double price = Double.parseDouble(priceStr);

        System.out.print("Types of Binding: ");
        String type = scanner.nextLine();

        System.out.print("Design Type: ");
        String desing = scanner.nextLine();

        System.out.print("Size: ");
        String size = scanner.nextLine();

        System.out.print("Brand: ");
        String brand = scanner.nextLine();

        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            MongoDatabase database = mongoClient.getDatabase("dbmongo");

            MongoCollection<Document> collection = database.getCollection("notebook");

            Document existing = collection.find(new Document("id", id)).first();

            if (existing != null) {
                System.out.println("Error: Ya existe un notebook con el id " + id);
                return;
            }

            Document document = new Document("id", id)
                    .append("stock", stock)
                    .append("price", price)
                    .append("type", type)
                    .append("desing", desing)
                    .append("size", size)
                    .append("brand", brand);

            collection.insertOne(document);

            System.out.println("registered.");
        } catch (Exception e) {
            System.err.println("Error conection with MongoDB: " + e.getMessage());
        }
    }

    public static void mostrarNotebook() {

        java.util.logging.Logger logger = java.util.logging.Logger.getLogger("org.mongodb.driver");
        logger.setLevel(java.util.logging.Level.WARNING);

        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            MongoDatabase database = mongoClient.getDatabase("dbmongo");

            MongoCollection<Document> collection = database.getCollection("notebook");

            System.out.println("\nNotebooks :");

            for (Document doc : collection.find()) {
                System.out.println(doc.toJson());
            }
        } catch (Exception e) {
            System.err.println("Error conection with MongoDB: " + e.getMessage());
        }
    }

    public static void actualizarNotebook() {

        System.out.print("update id : ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("stock: ");
        int stock = scanner.nextInt();

        System.out.print("Price: ");
        float price = scanner.nextFloat();
        scanner.nextLine();

        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            MongoDatabase database = mongoClient.getDatabase("dbmongo");

            MongoCollection<Document> collection = database.getCollection("notebook");

            Document filtro = new Document("id", id);
            Document nuevosValor = new Document("$set", new Document("stock", stock)
                    .append("price", price));

            collection.updateOne(filtro, nuevosValor);

            System.out.println("Registro actualizado.");
        } catch (Exception e) {
            System.err.println("Error de conexión con MongoDB: " + e.getMessage());
        }
    }

    public static void eliminarNotebook() {

        System.out.print("Delete Id: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            MongoDatabase database = mongoClient.getDatabase("dbmongo");

            MongoCollection<Document> collection = database.getCollection("notebook");

            Document filtro = new Document("id", id);
            collection.deleteOne(filtro);

            System.out.println("Registed eliminated.");
        } catch (Exception e) {
            System.err.println("Error conection with MongoDB: " + e.getMessage());
        }
    }

    public static void menuCRUD() {
        int opcion;

        do {
            System.out.println("\n Menu CRUD:");
            System.out.println("1. add notebook.");
            System.out.println("2. show notbooks.");
            System.out.println("3. update notebook.");
            System.out.println("4. delete notebook.");
            System.out.println("0. Back.");

            System.out.print("choose an option: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    insertarNotebook();
                    break;

                case 2:
                    mostrarNotebook();
                    break;

                case 3:
                    actualizarNotebook();
                    break;

                case 4:
                    eliminarNotebook();
                    break;

                case 0:
                    System.out.println("Back.");
                    break;

                default:
                    System.out.println("try again.");
                    break;
            }
        } while (opcion != 0);
    }

    public static void menu() {
        int opcion;

        do {

            System.out.println("\n Menu:");
            System.out.println("1. Notebooks ");
            System.out.println("2. Buy ");
            System.out.println("0. Exit");

            System.out.print("choose an option: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    menuCRUD();

                    break;

                case 2:
                    comprarNotebook();
                    break;

                case 0:
                    System.out.println("EXIT.");
                    break;

                default:
                    System.out.println("Try again.");
                    break;
            }
        } while (opcion != 0);

        scanner.close();
    }
}
