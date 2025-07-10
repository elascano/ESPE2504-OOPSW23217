package ec.edu.espe.soundmixer.controller;

import ec.edu.espe.vehicle.dao.MongoDbConnection;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.model.Filters;
import javax.swing.JOptionPane;
import org.bson.Document;

/**
 *
 * @author PC
 */
public class VehicleDeleteRepository {

    public boolean deleteBySerialNumber(String serialNumber) {
        MongoCollection<Document> collection = MongoDbConnection.getCollection();
        DeleteResult result = collection.deleteOne(Filters.eq("serialNumber", serialNumber));
        if(serialNumber.equals("")){
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un número de serie.");
            return false;
        }
        else if (result.getDeletedCount() > 0) {
            JOptionPane.showMessageDialog(null, "Vehicle eliminado correctamente.");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró un vehicle con ese número de serie.");
            return false;
        }
    }
}