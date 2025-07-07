package ec.edu.espe.q71to100.util;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import ec.edu.espe.q71to100.model.Product;
import java.util.ArrayList;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author Bonilla David SoftCrafters
 */
public class FileManagerProduct {

    private static FileManagerProduct instance;
    private MongoCollection<Document> collection;

    private FileManagerProduct() {
        collection = MongoClientConnection.getInstance()
                .getDatabase()
                .getCollection("products");
    }

    public static synchronized FileManagerProduct getInstance() {
        if (instance == null) {
            instance = new FileManagerProduct();
        }
        return instance;
    }

    //Method CRUD
    public void save(Product product) {
        Document doc = new Document("id", product.getId())
                .append("name", product.getName())
                .append("value", product.getValue())
                .append("quantity", product.getQuantity());
        collection.insertOne(doc);
    }

    public ArrayList<Product> readAll() {
        ArrayList<Product> products = new ArrayList<>();
        for (Document doc : collection.find()) {
            products.add(documentToProduct(doc));
        }
        return products;
    }

    public Product findById(int id) {
        Bson filter = Filters.eq("id", id);
        Document doc = collection.find(filter).first();
        if (doc != null) {
            return documentToProduct(doc);
        }
        return null;
    }

    public boolean update(Product product) {
        Bson filter = Filters.eq("id", product.getId());
        Document update = new Document("$set", new Document()
                .append("name", product.getName())
                .append("value", product.getValue())
                .append("quantity", product.getQuantity()));
        UpdateResult result = collection.updateOne(filter, update);
        return result.getModifiedCount() > 0;
    }

    public boolean delete(int id) {
        Bson filter = Filters.eq("id", id);
        DeleteResult result = collection.deleteOne(filter);
        return result.getDeletedCount() > 0;
    }

    private Product documentToProduct(Document doc) {
        int id = doc.getInteger("id");
        String name = doc.getString("name");
        float value = doc.getDouble("value").floatValue();
        int quantity = doc.getInteger("quantity");
        return new Product(id, name, value, quantity);
    }

    public static void setInstance(FileManagerProduct aInstance) {
        instance = aInstance;
    }

    public MongoCollection<Document> getCollection() {
        return collection;
    }

    public void setCollection(MongoCollection<Document> collection) {
        this.collection = collection;
    }
}
