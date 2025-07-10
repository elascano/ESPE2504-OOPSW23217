package ec.edu.espe.soundmixer.controller;

import ec.edu.espe.vehicle.dao.MongoDbConnection;
import ec.edu.espe.vehicle.model.Vehicle;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;

/**
 *
 * @author PC
 */
public class VehicleSearchRepository {
    public Vehicle findBySerialNumber(String serialNumber) {
        if (serialNumber == null || serialNumber.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(null, "Ingrese un número de serie.");
            return null;
        }
        MongoCollection<Document> collection = MongoDbConnection.getCollection();
        Document doc = collection.find(Filters.eq("serialNumber", serialNumber)).first();
        if (doc != null) {
            return new Vehicle(
                    doc.getString("brand"),
                    doc.getString("model"),
                    doc.getBoolean("isDigital", false),
                    doc.getInteger("numChannels", 0),
                    doc.getDouble("price").floatValue(),
                    doc.getString("serialNumber")
            );
        } else {
            javax.swing.JOptionPane.showMessageDialog(null, "No se encontró un SoundMixer con ese número de serie.");
            return null;
        }
    }
}
