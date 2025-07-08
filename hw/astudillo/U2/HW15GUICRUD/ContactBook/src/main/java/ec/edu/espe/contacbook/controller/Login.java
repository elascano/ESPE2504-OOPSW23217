/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.contacbook.controller;

import com.mongodb.client.MongoCollection;
import javax.swing.JOptionPane;
import org.bson.Document;
import ec.edu.espe.contacbook.view.*;

/**
 *
 * @author PC
 */
public class Login {
    public static boolean login(String username, String password, javax.swing.JFrame loginFrame) {
    if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.");
        return false;
    }
    MongoCollection<Document> userCollection = MongoDbConecction.getUserCollection();
    Document user = userCollection.find(new Document("username", username)).first();
    if (user == null) {
        JOptionPane.showMessageDialog(null, "El usuario no existe.");
        return false;
    }
    String storedPassword = user.getString("password");
    if (!storedPassword.equals(password)) {
        JOptionPane.showMessageDialog(null, "Contraseña incorrecta.");
        return false;
    }
    ContactMenu contactMenu = new ContactMenu();
    contactMenu.setVisible(true);
    loginFrame.dispose();
    return true;
}
}
