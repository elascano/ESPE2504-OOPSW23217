package com.mycompany.ScissorCrud;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import static com.mongodb.client.model.Filters.*;

import java.util.Scanner;

public class ScissorCrud {

    // Clase interna Scissors
    static class Scissors {
        private String brand;
        private double price;
        private String color;

        public Scissors(String brand, double price, String color) {
            this.brand = brand;
            this.price = price;
            this.color = color;
        }

        public Document toDocument() {
            return new Document("brand", brand)
                    .append("price", price)
                    .append("color", color);
        }

        public static Scissors fromDocument(Document doc) {
            return new Scissors(
                doc.getString("brand"),
                doc.getDouble("price"),
                doc.getString("color")
            );
        }

        @Override
        public String toString() {
            return "Scissors{" + "brand='" + brand + '\'' + ", price=" + price + ", color='" + color + '\'' + '}';
        }
    }

    // Conexión MongoDB
    private static final String URI = "mongodb+srv://mjunda1:MateoUndaJM05@cluster0.7yle2fx.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
    private static final String DB_NAME = "WarGame";
    private static final String COLLECTION_NAME = "scissorsCRUD";

    private static final MongoCollection<Document> collection = MongoClients.create(URI)
            .getDatabase(DB_NAME)
            .getCollection(COLLECTION_NAME);

    // Menú principal
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- CRUD Tijeras ---");
            System.out.println("1. Insertar");
            System.out.println("2. Mostrar");
            System.out.println("3. Actualizar");
            System.out.println("4. Eliminar");
            System.out.println("5. Calcular Total y Promedio");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1 -> insertar(scanner);
                case 2 -> mostrar();
                case 3 -> actualizar(scanner);
                case 4 -> eliminar(scanner);
                case 5 -> calcular();
                case 6 -> System.out.println("Hasta luego");
                default -> System.out.println("Opción inválida");
            }
        } while (opcion != 6);
    }

    private static void insertar(Scanner scanner) {
        System.out.print("Marca: ");
        String brand = scanner.nextLine();
        System.out.print("Precio: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Color: ");
        String color = scanner.nextLine();

        Scissors scissor = new Scissors(brand, price, color);
        collection.insertOne(scissor.toDocument());
        System.out.println("Tijera insertada.");
    }

    private static void mostrar() {
        FindIterable<Document> scissors = collection.find();
        for (Document doc : scissors) {
            System.out.println(Scissors.fromDocument(doc));
        }
    }

    private static void actualizar(Scanner scanner) {
        System.out.print("Marca a actualizar: ");
        String brand = scanner.nextLine();
        System.out.print("Nuevo precio: ");
        double newPrice = scanner.nextDouble();
        scanner.nextLine();

        Document update = new Document("$set", new Document("price", newPrice));
        collection.updateOne(eq("brand", brand), update);
        System.out.println("Tijera actualizada.");
    }

    private static void eliminar(Scanner scanner) {
        System.out.print("Marca a eliminar: ");
        String brand = scanner.nextLine();
        collection.deleteOne(eq("brand", brand));
        System.out.println("Tijera eliminada.");
    }

    private static void calcular() {
        FindIterable<Document> scissors = collection.find();
        double suma = 0;
        int contador = 0;

        for (Document doc : scissors) {
            double precio = doc.getDouble("price");
            suma += precio;
            contador++;
        }

        double promedio = (contador > 0) ? (suma / contador) : 0;

        System.out.println("Suma total de precios: $" + suma);
        System.out.println("Promedio de precios: $" + promedio);
    }
}
