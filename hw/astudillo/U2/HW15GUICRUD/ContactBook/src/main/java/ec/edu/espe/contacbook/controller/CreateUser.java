/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.contacbook.controller;
import com.mongodb.client.MongoCollection;
import ec.edu.espe.contacbook.view.FrmSignUp;
import org.bson.Document;

import javax.swing.*;

/**
 *
 * @author PC
 */
public class CreateUser {
    public boolean createUser(String username, String password) {
        MongoCollection<Document> userCollection = MongoDbConecction.getUserCollection();

        Document existingUser = userCollection.find(new Document("username", username)).first();
        if (existingUser != null) {
            return false;
        }

        Document newUser = new Document("username", username)
                .append("password", password);

        userCollection.insertOne(newUser);
        return true;
    }

    public static void registerUserFromForm(FrmSignUp form) {
        String username = form.getUsername();
        String password = form.getPassword();

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(form, "Llene todos los campos");
            return;
        }

        CreateUser createUser = new CreateUser();
        boolean created = createUser.createUser(username, password);

        if (created) {
            JOptionPane.showMessageDialog(form, "Usuario creado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(form, "El nombre de usuario ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
