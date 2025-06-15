package ec.edu.espe.soundmixer.controller;

import ec.edu.espe.soundmixer.model.SoundMixer;
import ec.edu.espe.soundmixer.dao.MongoDbConnection;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import javax.swing.JOptionPane;
import org.bson.Document;

/**
 *
 * @author PC
 */
public class SoundMixerRepository {
    public SoundMixer createSoundMixer(String brand, String model, boolean isDigital, int numChannels, float price, String serialNumber) {
        if(brand.equals("")||model.equals("")||numChannels==0||price==0){
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.");
            return null;
        }
        else if (existsBySerialNumber(serialNumber)) {
            JOptionPane.showMessageDialog(null, "El número de serie ya existe.");
            return null;
        }
        SoundMixer soundMixer = new SoundMixer(brand, model, isDigital, numChannels, price, serialNumber);
        saveIfNotExists(soundMixer);
        return soundMixer;
    }

    public boolean existsBySerialNumber(String serialNumber) {
        MongoCollection<Document> collection = MongoDbConnection.getCollection();
        Document found = collection.find(Filters.eq("serialNumber", serialNumber)).first();
        return found != null;
    }

    public boolean saveIfNotExists(SoundMixer soundMixer) {
        if (existsBySerialNumber(soundMixer.getSerialNumber())) {
            JOptionPane.showMessageDialog(null, "El número de serie ya existe.");
            return false;
        }
        MongoCollection<Document> collection = MongoDbConnection.getCollection();
        Document doc = new Document("brand", soundMixer.getBrand())
                .append("model", soundMixer.getModel())
                .append("isDigital", soundMixer.isIsDigital())
                .append("numChannels", soundMixer.getNumChannels())
                .append("price", soundMixer.getPrice())
                .append("serialNumber", soundMixer.getSerialNumber());
        collection.insertOne(doc);
        JOptionPane.showMessageDialog(null, "SoundMixer guardado correctamente.");
        return true;
    }
    public void updateSoundMixer(String brand, String model, boolean isDigital, int numChannels, float price, String serialNumber) {
        MongoCollection<Document> collection = MongoDbConnection.getCollection();
        Document update = new Document("$set", new Document("brand", brand)
                .append("model", model)
                .append("isDigital", isDigital)
                .append("numChannels", numChannels)
                .append("price", price));
        collection.updateOne(Filters.eq("serialNumber", serialNumber), update);
    }
}