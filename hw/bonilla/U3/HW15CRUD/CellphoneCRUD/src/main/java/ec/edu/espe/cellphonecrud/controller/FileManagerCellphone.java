package ec.edu.espe.cellphonecrud.controller;

import com.mongodb.client.MongoCollection;
import ec.edu.espe.cellphonecrud.model.Cellphone;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.bson.Document;

/**
 *
 * @author Bonilla David SoftCrafters
 */
public class FileManagerCellphone {

    public static MongoClientConnection connection = new MongoClientConnection();
    public static MongoDatabase database = connection.getDatabase();
    public static MongoCollection<Document> collection = database.getCollection("cellphones");

    //Method Create
    public static void saveCellphoneMongoDB(Cellphone cellphone) {

        Document object = new Document("id", cellphone.getId()).append("width", cellphone.getWidth()).append("height", cellphone.getHeight()).append("type", cellphone.getType()).append("priceFinal", cellphone.getPriceFinal());

        try {
            collection.insertOne(object);
            System.out.println("Cellphone saved");
        } catch (Exception e) {
            System.err.println("Error saving in MongoDB");
        }
    }

    //Method Read
    public static List<Cellphone> readCellphonesMongoDB() {

        List<Cellphone> cellphones = new ArrayList<>();

        for (Document doc : collection.find()) {
            int id = doc.getInteger("id");
            int width = doc.getInteger("width");
            int height = doc.getInteger("height");
            String type = doc.getString("type");
            double priceFinal = doc.getDouble("priceFinal");

            Cellphone cellphone = new Cellphone(id, width, height, type, priceFinal);
            cellphones.add(cellphone);
        }

        return cellphones;
    }

    //Method Update
    public static void updateCellphoneMongoDB(int id) {
        Scanner scanner = new Scanner(System.in);

        Document existingCellphone = collection.find(Filters.eq("id", id)).first();

        if (existingCellphone != null) {

            System.out.println("Enter new width: ");
            int width = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter new height: ");
            int height = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter new type: ");
            String type = scanner.nextLine();
            double priceFinal = Cellphone.calculateManufacturingCost(type);

            collection.updateOne(Filters.eq("id", id),
                    Updates.combine(
                            Updates.set("width", width),
                            Updates.set("height", height),
                            Updates.set("type", type),
                            Updates.set("priceFinal", priceFinal)
                    )
            );
            scanner.close();
            System.out.println("Cellphone updated successfully.");
        } else {
            System.out.println("Cellphone with ID " + id + " not found.");
        }
    }

    //Method Delete
    public static void deleteCellphoneMongoDB(int id) {
        
        DeleteResult result = collection.deleteOne(Filters.eq("id", id));

        if (result.getDeletedCount() > 0) {
            System.out.println("Cellphone deleted successfully.");
        } else {
            System.out.println("No cellphone found with ID " + id);
        }
    }

}
