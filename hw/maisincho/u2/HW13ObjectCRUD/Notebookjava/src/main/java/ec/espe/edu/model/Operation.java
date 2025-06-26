
package ec.espe.edu.model;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import static ec.espe.edu.model.CRUD.connectionString;
import static ec.espe.edu.model.CRUD.mostrarNotebook;
import static ec.espe.edu.model.CRUD.scanner;
import org.bson.Document;

/**
 *
 * @author Isaac Maisincho Crafters_Market DCCO ESPE
 */
public class Operation {
    
 public static void comprarNotebook() {
    System.out.println("\nNotebooks:");
    mostrarNotebook();

    System.out.print("Insert ID to purchase: ");
    int id = scanner.nextInt();
    scanner.nextLine();

    System.out.print("quantity to purchase : ");
    int cantidad = scanner.nextInt();
    scanner.nextLine();

    try (MongoClient mongoClient = MongoClients.create(connectionString)) {
        MongoDatabase database = mongoClient.getDatabase("dbmongo");

        MongoCollection<Document> collection = database.getCollection("notebook");

        Document notebook = collection.find(Filters.eq("id", id)).first();

        if (notebook == null) {
            System.out.println("Notebook no encontrado.");
            return;
        }

        int stock = notebook.getInteger("stock", 0);
        double price = notebook.getDouble("price");

        if (cantidad > stock) {
            System.out.println("out of stock.");
            return;
        }

        double total = price * cantidad;

        if (total > 20) {
            total *= 0.90; 
            System.out.println("10% discount.");
        } else if (total > 5) {
            total *= 0.95; 
            System.out.println("5% discount.");
        }

        System.out.println("Has comprado " + cantidad + " notebook(s).");

        System.out.println("Valor total de la compra: " + total);

        collection.updateOne(Filters.eq("id", id),
                Updates.inc("stock", -cantidad));

        System.out.println("Stock actualizado.");

    } catch (Exception e) {
        System.err.println("Error de conexión con MongoDB: " + e.getMessage()); 
    }
}
}