package ec.edu.espe.examen.utils;

/**
 *
 * @author LABS-ESPE
 */
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoDB {
    private static final String URL = "mongodb+srv://isaac:isaac@cluster0.xaitfht.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
    private static final String nameDB = "Exam";

    private static MongoDB instance;
    private MongoDatabase database;

    private MongoDB() {
        MongoClient mongoClient = MongoClients.create(URL);
        database = mongoClient.getDatabase(nameDB);
    }

    public static synchronized MongoDB getInstance() {
        if (instance == null) {
            instance = new MongoDB();
        }
        return instance;
    }

    public MongoDatabase getDatabase() {
        return database;
    }
}
