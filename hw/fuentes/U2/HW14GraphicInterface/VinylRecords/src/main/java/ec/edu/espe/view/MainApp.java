package ec.edu.espe.view;

import com.mongodb.client.MongoDatabase;
import ec.edu.espe.utils.MongoConnection;

/**
 *
 * @author jorge
 */
public class MainApp {
    public static void main(String[] args){
        System.out.println("Trying to connect to MongoDB Atlas...");
        try{
            MongoDatabase db =MongoConnection.ConnectToMongo();
            System.out.println("Successfully connected to the database");
            
            new VisualMenu();
            
        }catch(Exception e){
            System.out.println("Error connecting to MongoDB" + e.getMessage());
        }
        
    }
}
