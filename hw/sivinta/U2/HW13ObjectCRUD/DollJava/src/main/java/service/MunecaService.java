package service;

import com.mongodb.client.*;
import model.Muneca;
import org.bson.Document;

import java.util.HashMap;
import java.util.Map;

public class MunecaService {

    private final MongoCollection<Document> coleccion;

    private final Map<String, Double> factorCalidad = new HashMap<>();

    public MunecaService() {
        String uri = "mongodb+srv://kjsivinta:kjsivinta@cluster0.timukmv.mongodb.net/";
        MongoClient mongoClient = MongoClients.create(uri);
        MongoDatabase database = mongoClient.getDatabase("crud_muneca");
        this.coleccion = database.getCollection("munecas");

        factorCalidad.put("Alta", 1.5);
        factorCalidad.put("Media", 1.2);
        factorCalidad.put("Baja", 1.0);
    }

    public void calcularCostos(Muneca m) {
        double factor = factorCalidad.getOrDefault(m.getCalidad(), 1.0);
        double costoCalidad = Math.round(m.getPrecio() * factor * 100.0) / 100.0;
        double costoEnvio = m.getPrecio() < 50 ? 5.00 : 10.00;
        double costoTotal = Math.round((m.getPrecio() + costoCalidad + costoEnvio) * 100.0) / 100.0;

        m.setCostoCalidad(costoCalidad);
        m.setCostoEnvio(costoEnvio);
        m.setCostoTotal(costoTotal);
    }

    public void guardarEnMongo(Muneca m) {
        Document doc = new Document("nombre", m.getNombre())
                .append("precio", m.getPrecio())
                .append("calidad", m.getCalidad())
                .append("costo_calidad", m.getCostoCalidad())
                .append("costo_envio", m.getCostoEnvio())
                .append("costo_total", m.getCostoTotal());

        coleccion.insertOne(doc);
    }
}

