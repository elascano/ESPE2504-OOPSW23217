package ec.edu.espe.utils;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
/**
 *
 * @author jorge
 */
public class MongoConnection {
    
    public static MongoDatabase ConnectToMongo(){
        String uri = "mongodb+srv://Jorge:Jorge@cluster0.ny8bieg.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
        MongoClient client = MongoClients.create(uri);
        MongoDatabase database = client.getDatabase("VinylRecords");
        return database;
        
    }
}
