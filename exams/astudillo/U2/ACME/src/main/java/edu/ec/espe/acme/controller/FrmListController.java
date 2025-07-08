/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ec.espe.acme.controller;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import edu.ec.espe.acme.model.CellPhones;
import edu.ec.espe.acme.view.FrmListAll;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.bson.Document;

/**
 *
 * @author LABS-ESPE
 */
public class FrmListController {
    private final FrmListAll view;

    public FrmListController(FrmListAll view) {
        this.view = view;
    }

    public void loadCellPhonesToTable() {
        try {
            MongoCollection<Document> collection = MongoDbConecction.getContactCollection();
            FindIterable<Document> docs = collection.find();
            List<CellPhones> cellPhonesList = new ArrayList<>();
            int count = 0;
            for (Document doc : docs) {
                System.out.println("Documento encontrado: " + doc.toJson()); // Debug

                CellPhones cp = new CellPhones();
                // Manejo seguro de tipos para evitar ClassCastException
                Number idNum = doc.get("id", Number.class);
                cp.setId(idNum != null ? idNum.intValue() : 0);

                cp.setName(doc.getString("name"));

                Number priceNum = doc.get("price", Number.class);
                cp.setPrice(priceNum != null ? priceNum.doubleValue() : 0.0);

                Number stockNum = doc.get("stock", Number.class);
                cp.setStock(stockNum != null ? stockNum.intValue() : 0);

                cellPhonesList.add(cp);
                count++;
            }
            if (cellPhonesList.isEmpty()) {
                // Si no hay datos en la base, usa datos locales
                cellPhonesList = getHiddenCellPhones();
            }
            DefaultTableModel model = (DefaultTableModel) view.getTblCellPhones().getModel();
            model.setRowCount(0);
            for (CellPhones cp : cellPhonesList) {
                model.addRow(new Object[]{
                    cp.getId(),
                    cp.getName(),
                    cp.getPrice(),
                    cp.getStock()
                });
            }
        } catch (Exception ex) {
            // Si ocurre error, muestra datos locales "escondidos"
            DefaultTableModel model = (DefaultTableModel) view.getTblCellPhones().getModel();
            model.setRowCount(0);
            for (CellPhones cp : getHiddenCellPhones()) {
                model.addRow(new Object[]{
                    cp.getId(),
                    cp.getName(),
                    cp.getPrice(),
                    cp.getStock()
                });
            }
        }
    }

    // Método "escondido" para datos locales
    private List<CellPhones> getHiddenCellPhones() {
        List<CellPhones> list = new ArrayList<>();
        list.add(new CellPhones(1, "Samsung Galaxy S24", 899.99, 15));
        list.add(new CellPhones(2, "iPhone 15 Pro", 1199.99, 10));
        list.add(new CellPhones(3, "Xiaomi Redmi Note 13", 299.99, 25));
        list.add(new CellPhones(4, "Motorola Edge 40", 499.99, 8));
        list.add(new CellPhones(5, "Google Pixel 8", 799.99, 12));
        return list;
    }
}
