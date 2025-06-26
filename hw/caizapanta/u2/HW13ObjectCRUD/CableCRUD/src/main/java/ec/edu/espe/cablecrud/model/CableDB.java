package ec.edu.espe.cablecrud.model;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import org.bson.Document;

/**
 *
 * @author Tammy Caizapanta SoftCrafters DCCO ESPE
 */

public class CableDB {
private MongoCollection<Document> collection;

    public CableDB() {
        MongoClient client = MongoClients.create("mongodb+srv://tacaizapanta:tacaizapanta@cluster0.ircnkvg.mongodb.net/");
        MongoDatabase database = client.getDatabase("CableDB");
        collection = database.getCollection("cables");
    }

    // Create cable document
    public void insertCable(Cable c) {
        Document doc = new Document("id", c.getId())
            .append("type", c.getType())
            .append("lengthMeters", c.getLengthMeters())
            .append("pricePerMeter", c.getPricePerMeter())
            .append("stockQuantity", c.getStockQuantity())
            .append("totalPrice", c.calculateTotalPrice());
        collection.insertOne(doc);
        System.out.println("Cable inserted.");
    }

    // Read and print all cables
    public void showCables() {
        for (Document doc : collection.find()) {
            System.out.println(doc.toJson());
        }
    }

    // Update pricePerMeter and totalPrice
    public void updatePrice(String id, double newPrice) {
        Document cable = collection.find(Filters.eq("id", id)).first();
        if (cable != null) {
            double length = cable.getDouble("lengthMeters");
            double newTotal = length * newPrice;
            collection.updateOne(Filters.eq("id", id),
                new Document("$set", new Document("pricePerMeter", newPrice).append("totalPrice", newTotal)));
            System.out.println("Price updated.");
        } else {
            System.out.println("Cable not found.");
        }
    }

    // Delete cable by id
    public void deleteCable(String id) {
        collection.deleteOne(Filters.eq("id", id));
        System.out.println("Cable deleted.");
    }
}