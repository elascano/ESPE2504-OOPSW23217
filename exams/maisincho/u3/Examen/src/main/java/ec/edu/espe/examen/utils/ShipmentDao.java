package ec.edu.espe.examen.utils;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import ec.edu.espe.examen.model.Client;
import ec.edu.espe.examen.model.ShipmentPackage;

public class ShipmentDao {
	public static void saveShipment(Client client, ShipmentPackage pkg) {
		MongoDatabase db = MongoDB.getInstance().getDatabase();
	MongoCollection<Document> collection = db.getCollection("Laarbox");

		Document doc = new Document()
				.append("client", new Document()
						.append("id", client.getId())
						.append("fullName", client.getFullName())
						.append("phone", client.getPhone())
						.append("email", client.getEmail())
						.append("address", client.getAddress())
						.append("vip", client.isVip()))
				.append("package", new Document()
						.append("type", pkg.getClass().getSimpleName())
						.append("weight", pkg.getWeightKg())
						.append("declaredValue", pkg.getDeclaredValue())
						.append("description", pkg.getDescription())
						.append("trackingCode", pkg.getTrackingCode())
						.append("fragile", pkg.isFragile())
						.append("originalPrice", pkg.getOriginalPrice())
						.append("finalPrice", pkg.getFinalPrice()));

		collection.insertOne(doc);
	}
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
