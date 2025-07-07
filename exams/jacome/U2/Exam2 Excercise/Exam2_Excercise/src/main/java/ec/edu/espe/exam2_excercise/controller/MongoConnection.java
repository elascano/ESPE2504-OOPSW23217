package ec.edu.espe.exam2_excercise.controller;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
/**
 *
 * @author LABS-ESPE
 */
public class MongoConnection {
    private static final String URI = "mongodb+srv://Micaela:Micaela@cluster0.dqlf2xq.mongodb.net/?retryWrites=true&w=majority";
    private static final String DATABASE_NAME = "craftmarket";

    private static MongoClient mongoClient;
    private static MongoDatabase database;
     public static MongoDatabase connect() {
        String uri ="mongodb+srv://machicaiza22:pan@cluster0.dqlf2xq.mongodb.net/?retryWrites=true&w=majority";
        MongoClient client = MongoClients.create(uri);
        return client.getDatabase("craftmarket");
    }
    static {
        try {
            mongoClient = MongoClients.create(URI);
            database = mongoClient.getDatabase(DATABASE_NAME);
            System.out.println("[MongoConnection] Connected to MongoDB Atlas successfully.");
        } catch (Exception e) {
            System.err.println("[MongoConnection] Error connecting to MongoDB: " + e.getMessage());
            database = null;
        }
}
    /**
     * Devuelve la instancia de la base de datos para todo el proyecto.
     * @return MongoDatabase conectado o null si hay error.
     */
    public static MongoDatabase getDatabase() {
        if (database == null) {
            System.err.println("[MongoConnection] Database is null, check your connection.");
        }
        return database;
    }

    /**
     * Cierra la conexión a MongoDB de forma segura.
     */
    public static void closeConnection() {
        if (mongoClient != null) {
            mongoClient.close();
            System.out.println("[MongoConnection] MongoDB connection closed.");
        }
    }
}
