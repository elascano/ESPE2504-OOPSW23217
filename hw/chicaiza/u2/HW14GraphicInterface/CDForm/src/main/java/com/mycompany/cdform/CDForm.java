/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.cdform;

/**
 *
 * @author Michael Chicaiza SOFTCRAF DCCO ESPE
 */

import com.mongodb.client.*;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;

import javax.swing.*;
import java.awt.event.*;
import static com.mongodb.client.model.Filters.eq;

public class CDForm {
    private static MongoCollection<Document> collection;

    public static void main(String[] args) {
        // Conexión a MongoDB Atlas
        MongoClient mongoClient = MongoClients.create("mongodb+srv://machicaiza22:pan@cluster0.dqlf2xq.mongodb.net");
        MongoDatabase db = mongoClient.getDatabase("cd_database");
        collection = db.getCollection("cds");

        // Interfaz gráfica
        JFrame frame = new JFrame("Gestión de CDs");
        frame.setSize(370, 480);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Centra la ventana

        // Etiquetas y campos
        JLabel[] labels = {
            new JLabel("ID:"), new JLabel("Marca:"), new JLabel("Modelo:"), new JLabel("Capacidad:"),
            new JLabel("Tipo:"), new JLabel("Precio:"), new JLabel("Año Lanzamiento:"), new JLabel("Espacio Usado:")
        };
        JTextField[] fields = new JTextField[8];

        int y = 20;
        for (int i = 0; i < labels.length; i++) {
            labels[i].setBounds(20, y, 140, 25);
            fields[i] = new JTextField();
            fields[i].setBounds(160, y, 170, 25);
            frame.add(labels[i]);
            frame.add(fields[i]);
            y += 35;
        }

        // Botones
        JButton saveBtn = new JButton("Guardar");
        JButton readBtn = new JButton("Buscar");
        JButton updateBtn = new JButton("Actualizar");
        JButton deleteBtn = new JButton("Eliminar");

        saveBtn.setBounds(20, 320, 140, 30);
        readBtn.setBounds(190, 320, 140, 30);
        updateBtn.setBounds(20, 370, 140, 30);
        deleteBtn.setBounds(190, 370, 140, 30);

        frame.add(saveBtn);
        frame.add(readBtn);
        frame.add(updateBtn);
        frame.add(deleteBtn);

        // Guardar
        saveBtn.addActionListener(e -> {
            try {
                Document doc = new Document("id", fields[0].getText())
                        .append("brand", fields[1].getText())
                        .append("model", fields[2].getText())
                        .append("capacity", fields[3].getText())
                        .append("type", fields[4].getText())
                        .append("price", Integer.parseInt(fields[5].getText()))
                        .append("releaseYear", Integer.parseInt(fields[6].getText()))
                        .append("usedSpace", Integer.parseInt(fields[7].getText()));
                collection.insertOne(doc);
                JOptionPane.showMessageDialog(frame, "CD guardado exitosamente.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error al guardar: " + ex.getMessage());
            }
        });

        // Buscar
        readBtn.addActionListener(e -> {
            Document doc = collection.find(eq("id", fields[0].getText())).first();
            if (doc != null) {
                fields[1].setText(doc.getString("brand"));
                fields[2].setText(doc.getString("model"));
                fields[3].setText(doc.getString("capacity"));
                fields[4].setText(doc.getString("type"));
                fields[5].setText(String.valueOf(doc.getInteger("price")));
                fields[6].setText(String.valueOf(doc.getInteger("releaseYear")));
                fields[7].setText(String.valueOf(doc.getInteger("usedSpace")));
                JOptionPane.showMessageDialog(frame, "CD encontrado.");
            } else {
                JOptionPane.showMessageDialog(frame, "CD no encontrado.");
            }
        });

        // Actualizar
        updateBtn.addActionListener(e -> {
            try {
                String id = fields[0].getText();
                if (id.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Por favor ingresa un ID.");
                    return;
                }

                Bson filter = eq("id", id);
                Document nuevosDatos = new Document("$set", new Document()
                        .append("brand", fields[1].getText())
                        .append("model", fields[2].getText())
                        .append("capacity", fields[3].getText())
                        .append("type", fields[4].getText())
                        .append("price", Integer.parseInt(fields[5].getText()))
                        .append("releaseYear", Integer.parseInt(fields[6].getText()))
                        .append("usedSpace", Integer.parseInt(fields[7].getText()))
                );

                UpdateResult result = collection.updateOne(filter, nuevosDatos);

                if (result.getMatchedCount() == 0) {
                    JOptionPane.showMessageDialog(frame, "No se encontró un CD con ese ID.");
                } else {
                    JOptionPane.showMessageDialog(frame, "CD actualizado correctamente.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error al actualizar: " + ex.getMessage());
            }
        });

        // Eliminar
        deleteBtn.addActionListener(e -> {
            try {
                long deleted = collection.deleteOne(eq("id", fields[0].getText())).getDeletedCount();
                if (deleted > 0) {
                    for (JTextField field : fields) field.setText("");
                    JOptionPane.showMessageDialog(frame, "CD eliminado correctamente.");
                } else {
                    JOptionPane.showMessageDialog(frame, "No se encontró un CD con ese ID.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error al eliminar: " + ex.getMessage());
            }
        });

        frame.setVisible(true);
    }
}
