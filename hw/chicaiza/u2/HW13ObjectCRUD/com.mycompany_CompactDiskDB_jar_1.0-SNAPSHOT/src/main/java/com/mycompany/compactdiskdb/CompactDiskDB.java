package com.mycompany.compactdiskdb;

import com.mongodb.client.*;
import org.bson.Document;
import java.util.Scanner;

public class CompactDiskDB {
    public static void main(String[] args) {
        // Conexión a MongoDB
        MongoClient mongoClient = MongoClients.create("mongodb+srv://machicaiza22:pan@cluster0.dqlf2xq.mongodb.net/");
        MongoDatabase database = mongoClient.getDatabase("cd_database");
        MongoCollection<Document> collection = database.getCollection("cds");

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Agregar disco");
            System.out.println("2. Eliminar disco por ID");
            System.out.println("3. Listar discos");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Marca: ");
                    String brand = scanner.nextLine();
                    System.out.print("Modelo: ");
                    String model = scanner.nextLine();

                    System.out.print("Capacidad (en GB): ");
                    double capacityNum = scanner.nextDouble();
                    scanner.nextLine(); // Limpiar buffer

                    System.out.print("Tipo: ");
                    String type = scanner.nextLine();

                    System.out.print("Precio: ");
                    double price = scanner.nextDouble();

                    System.out.print("Año de lanzamiento: ");
                    int year = scanner.nextInt();

                    System.out.print("Espacio usado (en GB): ");
                    double used = scanner.nextDouble();

                    if (used > capacityNum) {
                        System.out.println("❌ Error: El espacio usado no puede ser mayor que la capacidad.");
                    } else {
                        double espacioLibre = capacityNum - used;

                        Document newCd = new Document("id", id)
                                .append("brand", brand)
                                .append("model", model)
                                .append("capacity", String.valueOf(capacityNum))
                                .append("type", type)
                                .append("price", price)
                                .append("releaseYear", year)
                                .append("usedSpace", used);

                        collection.insertOne(newCd);
                        System.out.println("✔ Disco insertado correctamente.");
                        System.out.println("💾 Espacio libre restante: " + espacioLibre + " GB");
                    }
                    break;

                case 2:
                    System.out.print("Ingresa el ID del disco a eliminar: ");
                    String deleteId = scanner.nextLine();
                    Document deleted = collection.findOneAndDelete(new Document("id", deleteId));
                    if (deleted != null) {
                        System.out.println("✔ Disco con id=" + deleteId + " eliminado.");
                    } else {
                        System.out.println("✘ Disco no encontrado.");
                    }
                    break;

                case 3:
                    System.out.println("📀 Lista de discos:");
                    for (Document doc : collection.find()) {
                        System.out.println(doc.toJson());
                    }
                    break;

                case 4:
                    System.out.println("👋 Saliendo del programa...");
                    break;

                default:
                    System.out.println("⚠ Opción no válida.");
            }
        } while (opcion != 4);

        mongoClient.close();
        scanner.close();
    }
}
