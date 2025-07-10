/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ec.espe.acme.controller;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;


/**
 *
 * @author LABS-ESPE
 */
public class MongoDbConecction {
    private static final String URI = "mongodb+srv://Gerald:Gerald@cluster0.ii5j1oo.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
    private static final String DB_NAME = "POO";
    private static MongoClient client = null;

    private static  MongoClient getClient() {
        if (client == null) {
            client = MongoClients.create(URI);
        }
        return client;
    }

    public static MongoCollection<Document> getContactCollection() {
        try {
            MongoDatabase database = getClient().getDatabase(DB_NAME);
            return database.getCollection("CellPhones");
        } catch (Exception e) {
            System.err.println("Error al conectar con la colección CellPhones: " + e.getMessage());
            throw e;
        }
    }
    
}
