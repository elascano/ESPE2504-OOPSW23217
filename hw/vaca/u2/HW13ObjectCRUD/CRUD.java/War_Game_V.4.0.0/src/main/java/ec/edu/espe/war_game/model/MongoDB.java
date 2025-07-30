package ec.edu.espe.war_game.model;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.WriteResult;

/**
 *
 * @author Kevin Vaca Edison's OOP ESPE
 */


public class MongoDB {
    public static void main(String[] args) {
        
        MongoClient mongo = createConnection();

        if (mongo != null) {
            try {
                DB db = mongo.getDB("WarGame");
                System.out.println("Conexion a la BD llamada WarGame MongoDB Atlas");
                
                /*
                searchSector(db, "Users", "Conocoto");

                readCollection(db, "Users");

                updateId(db, "Users", "WG-00", "WG-05", true, null);
                updateSector(db, "Users", "Comite del Pueblo", "Sangolqui", true, "type", "Subordinate");

                deleteUser(db, "Users", "Edison's");
                */

            } finally {
                mongo.close();
            }
        }
    }
        
    public static MongoClient createConnection() {
        
        System.out.println("Conecction to Atlas");
       
        String uri = "mongodb+srv://KevinV593:KevinV593@cluster0.7ufczsp.mongodb.net/?retryWrites=true&w=majority&authSource=admin";
        
        try {
            MongoClient mongo = new MongoClient(new MongoClientURI(uri));
            System.out.println("Conexion exitosa!");
            return mongo;
        } catch (Exception e) {
            System.err.println("Conexion fallida: " + e.getMessage());
            return null;
        }
    }
    
    private static void createUser(DB db, String collection, String id, String type, String user, String password, String country, String sector) {
        DBCollection collec = db.getCollection(collection);
        
        BasicDBObject document = new BasicDBObject();
        document.put("id", id);
        document.put("type", type);
        document.put("user", user);
        document.put("password", password);
        document.put("country", country);
        document.put("sector", sector);
        
        collec.insert(document);
    }

    private static void readCollection(DB db, String collection) {
        DBCollection collec = db.getCollection(collection);
        
        DBCursor cursor = collec.find();
        
        while(cursor.hasNext()) {
            System.out.println("* "+ cursor.next().get("id") + " - "
                + cursor.curr().get("type") + " - "                   + cursor.curr().get("user") + " - "
                + cursor.curr().get("password") + " - "
                + cursor.curr().get("country") + " - "
                + cursor.curr().get("sector"));            
        }
    }

    private static void searchSector(DB db, String collection, String specificSector) {
        DBCollection collec = db.getCollection(collection);
        
        BasicDBObject query = new BasicDBObject();
        query.put("sector", specificSector);
        
        DBCursor cursor = collec.find(query);
        while (cursor.hasNext()){
            System.out.println("* " + cursor.next().get("sector") + " - "
                + cursor.curr().get("user"));
        }
    }

    private static void updateSector(DB db, String collection, String currentSector, String updateSector, boolean updateAll, String uniqueField, String uniqueValue ) {
        try {
        DBCollection collec = db.getCollection(collection);
        BasicDBObject filter = new BasicDBObject("sector", currentSector);
        
        if (uniqueField != null && uniqueValue != null) {
            filter.append(uniqueField, uniqueValue);
        }
        
        BasicDBObject updateQuery = new BasicDBObject("$set", new BasicDBObject("sector", updateSector));

        WriteResult result;
        if (updateAll) {
            result = collec.updateMulti(filter, updateQuery);
        } else {
            result = collec.update(filter, updateQuery); 
        }
        
        System.out.println("Updated " + result.getN() + " sector from '" + currentSector + "' to '" + updateSector + "'");
                
        } catch (Exception e) {
            System.err.println("Error updating sectors: " + e.getMessage());
        }
    }
    
    private static void updateId(DB db, String collection, String currentId, String updateId, boolean updateAll, String specificUser ) {
        try {
        DBCollection collec = db.getCollection(collection);
        BasicDBObject filter = new BasicDBObject("id", currentId);
        
        if (specificUser != null) {
            filter.append("user", specificUser);
        }
        
        BasicDBObject updateQuery = new BasicDBObject("$set", new BasicDBObject("id", updateId));

        WriteResult result;
        if (updateAll) {
            result = collec.updateMulti(filter, updateQuery);
        } else {
            result = collec.update(filter, updateQuery); 
        }
        
        System.out.println("Actualizacion de id/s" + currentId + "' de -->" + specificUser + " a nueva id '" + updateId + "'");
                
        } catch (Exception e) {
            System.err.println("Error updating sectors: " + e.getMessage());
        }
    }

    private static void deleteUser(DB db, String collection, String specificUser) {
        DBCollection collec = db.getCollection(collection);
        
        collec.remove(new BasicDBObject().append("user", specificUser));
    }

}