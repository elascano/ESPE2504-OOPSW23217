package ec.espe.edu.systemstudents.view;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.Scanner;

public class SystemSoundMixer {
    private static final String URI = "mongodb+srv://Gerald:Gerald@cluster0.rdplxx4.mongodb.net/";
    private static final String DB_NAME = "POO";
    private static final String COLLECTION = "SoundMixers";
    private static float precioUSDOriginal = 0f;

    public static void main(String[] args) {
        try (MongoClient mongoClient = MongoClients.create(URI)) {
            MongoDatabase db = mongoClient.getDatabase(DB_NAME);
            MongoCollection<Document> mixers = db.getCollection(COLLECTION);
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\n--- SOUND MIXER ---");
                System.out.println("1. Subir");
                System.out.println("2. Buscar");
                System.out.println("3. Actualizar");
                System.out.println("4. Eliminar");
                System.out.println("5. Salir");
                System.out.print("Elige una opción: ");
                String opcion = scanner.nextLine();

                switch (opcion) {
                    case "1": subir(mixers, scanner); break;
                    case "2": buscar(mixers, scanner); break;
                    case "3": actualizar(mixers, scanner); break;
                    case "4": eliminar(mixers, scanner); break;
                    case "5": return;
                    default: System.out.println("Opción inválida.");
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void subir(MongoCollection<Document> mixers, Scanner scanner) {
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("¿Es digital? (s/n): ");
        boolean digital = scanner.nextLine().equalsIgnoreCase("s");
        System.out.print("Número de canales: ");
        int canales;
        try {
            canales = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Número de canales inválido.");
            return;
        }
        System.out.print("Precio (USD): ");
        float precio;
        try {
            precio = Float.parseFloat(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Precio inválido.");
            return;
        }
        System.out.print("Número serial: ");
        String serial = scanner.nextLine();

        Document doc = new Document("brand", marca)
                .append("model", modelo)
                .append("digital", digital)
                .append("channels", canales)
                .append("priceUSD", precio)
                .append("serial", serial);

        mixers.insertOne(doc);
        System.out.println("Subido correctamente.");
    }

    private static void buscar(MongoCollection<Document> mixers, Scanner scanner) {
        System.out.print("Número serial: ");
        String serial = scanner.nextLine();
        Document mixer = mixers.find(Filters.eq("serial", serial)).first();
        if (mixer != null) {
            Object priceObj = mixer.get("priceUSD");
            if (priceObj instanceof Double) {
                precioUSDOriginal = ((Double) priceObj).floatValue();
            } else if (priceObj instanceof Integer) {
                precioUSDOriginal = ((Integer) priceObj).floatValue();
            } else if (priceObj instanceof Float) {
                precioUSDOriginal = (Float) priceObj;
            } else {
                precioUSDOriginal = 0f;
            }
            System.out.println("Marca: " + mixer.getString("brand"));
            System.out.println("Modelo: " + mixer.getString("model"));
            System.out.println("Tipo: " + (mixer.getBoolean("digital") ? "Digital" : "Analógico"));
            System.out.println("Canales: " + mixer.getInteger("channels"));
            System.out.println("Precio en USD: " + precioUSDOriginal);
            System.out.print("Moneda (USD/EUR/MXN/JPY): ");
            String moneda = scanner.nextLine();
            float precioConvertido = convertirMoneda(precioUSDOriginal, moneda);
            System.out.println("Precio en " + moneda + ": " + precioConvertido);
        } else {
            System.out.println("No encontrado.");
        }
    }

    private static void actualizar(MongoCollection<Document> mixers, Scanner scanner) {
        System.out.print("Número serial a actualizar: ");
        String serial = scanner.nextLine();
        Document mixer = mixers.find(Filters.eq("serial", serial)).first();
        if (mixer == null) {
            System.out.println("No encontrado.");
            return;
        }
        System.out.print("Nueva marca: ");
        String marca = scanner.nextLine();
        System.out.print("Nuevo modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("¿Es digital? (s/n): ");
        boolean digital = scanner.nextLine().equalsIgnoreCase("s");
        System.out.print("Nuevo número de canales: ");
        int canales;
        try {
            canales = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Número de canales inválido.");
            return;
        }
        // El precio se mantiene en USD original
        mixers.updateOne(Filters.eq("serial", serial),
                new Document("$set", new Document("brand", marca)
                        .append("model", modelo)
                        .append("digital", digital)
                        .append("channels", canales)
                        .append("priceUSD", precioUSDOriginal)
                        .append("serial", serial)));
        System.out.println("Actualizado correctamente.");
    }

    private static void eliminar(MongoCollection<Document> mixers, Scanner scanner) {
        System.out.print("Número serial a eliminar: ");
        String serial = scanner.nextLine();
        mixers.deleteOne(Filters.eq("serial", serial));
        System.out.println("Eliminado correctamente.");
    }

    private static float convertirMoneda(float priceUSD, String currency) {
        switch (currency.toUpperCase()) {
            case "EUR": return Math.round(priceUSD * 0.9f * 100) / 100f;
            case "MXN": return Math.round(priceUSD * 17f * 100) / 100f;
            case "JPY": return Math.round(priceUSD * 150f * 100) / 100f;
            default: return priceUSD;
        }
    }
}