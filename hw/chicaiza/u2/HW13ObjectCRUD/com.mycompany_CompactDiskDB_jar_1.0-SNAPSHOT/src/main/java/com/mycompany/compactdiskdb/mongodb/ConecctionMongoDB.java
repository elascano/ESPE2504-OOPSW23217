package com.mycompany.compactdiskdb.mongodb;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class ConecctionMongoDB {

    private static final String URI = "mongodb+srv://machicaiza22:pan@cluster0.dqlf2xq.mongodb.net/?retryWrites=true&w=majority";
    private static final String DATABASE = "craftmarket";
    private static final String COLLECTION = "compactDisks";
    private static MongoClient client;

    public static MongoCollection<Document> getCollection() {
        if (client == null) {
            ConnectionString connectionString = new ConnectionString(URI);
            client = MongoClients.create(connectionString);
        }
        MongoDatabase database = client.getDatabase(DATABASE);
        return database.getCollection(COLLECTION);
    }

    public static void close() {
        if (client != null) {
            client.close();
        }
    }
}
