package ec.edu.espe.contacbook.controller;

import ec.edu.espe.contacbook.model.Contact;
import ec.edu.espe.contacbook.util.Validator;
import ec.edu.espe.contacbook.view.FrmContactAdd;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class CreateContact {

    public static String saveContact(Contact contact) {
        MongoCollection<Document> collection = MongoDbConecction.getContactCollection();

        if (contact.getId() == 0 ||
                contact.getFirsName() == null || contact.getFirsName().trim().isEmpty() ||
                contact.getLastName() == null || contact.getLastName().trim().isEmpty() ||
                contact.getCellphoneNumer() == null || contact.getCellphoneNumer().trim().isEmpty() ||
                contact.getEmail() == null || contact.getEmail().trim().isEmpty() ||
                contact.getBornOnType() == null || contact.getBornOnType().trim().isEmpty()) {
            return "Por favor, complete todos los campos obligatorios.";
        }

        if (!Validator.isValidEmail(contact.getEmail())) {
            return "Correo electrónico no válido.";
        }

        if (!Validator.isValidPhoneNumber(contact.getCellphoneNumer())) {
            return "Número de teléfono no válido.";
        }

        Document existing = collection.find(new Document("id", contact.getId())).first();
        if (existing != null) {
            return "El ID ya existe. Por favor, ingrese otro.";
        }

        // Convertir deportes a lista de descripciones (String)
        List<String> sportsList = new ArrayList<>();
        if (contact.getSports() != null) {
            for (Object sport : contact.getSports()) {
                sportsList.add(sport.toString());
            }
        }

        Document doc = new Document("id", contact.getId())
                .append("firstName", contact.getFirsName())
                .append("lastName", contact.getLastName())
                .append("cellphoneNumer", contact.getCellphoneNumer())
                .append("email", contact.getEmail())
                .append("frequentFriend", contact.isFrequentFriend())
                .append("type", contact.getType())
                .append("bornOnType", contact.getBornOnType())
                .append("comments", contact.getComments())
                .append("sports", sportsList);

        collection.insertOne(doc);
        return "Contacto guardado exitosamente.";
    }

    public static void registerContactFromForm(FrmContactAdd form) {
        try {
            int id = Integer.parseInt(form.getTxtid().getText().trim());
            String firstName = form.getTxtfirstName().getText().trim();
            String lastName = form.getTxtlastName().getText().trim();
            String cellphone = form.getTxtcellphonerNumer().getText().trim();
            String email = form.getTxtemail().getText().trim();
            boolean frequentFriend = form.getCmbfrequentFriend().getSelectedItem().toString().equalsIgnoreCase("Yes");
            String type = form.getCmbtype().getSelectedItem().toString();
            String birthDate = form.getTxtbirthDate().getText().trim();
            String comments = form.getTxtcomments().getText().trim();

            // Solo descripciones de deportes (String)
            ArrayList<String> sports = new ArrayList<>(form.getLstsports().getSelectedValuesList());

            // Puedes modificar el constructor de Contact para aceptar ArrayList<String> o hacer la conversión dentro de Contact
            Contact contact = new Contact(
                    id, firstName, lastName, cellphone, email, frequentFriend, type, birthDate, comments, sports
            );

            String result = saveContact(contact);
            JOptionPane.showMessageDialog(form, result);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(form, "El ID debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}