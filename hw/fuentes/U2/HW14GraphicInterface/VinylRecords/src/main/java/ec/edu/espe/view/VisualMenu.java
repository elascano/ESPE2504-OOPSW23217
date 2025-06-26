package ec.edu.espe.view;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import ec.edu.espe.model.VinylRecord;
import ec.edu.espe.utils.MongoConnection;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.bson.Document;

/**
 *
 * @author jorge
 */
public class VisualMenu extends JFrame {
    private MongoDatabase db;
    private MongoCollection<Document> collection;
    public VisualMenu(){
        setTitle("Record Vinyl Record");
        setSize(400,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(12, 2, 0, 0));
        
        add(new JLabel(" tittle:"));
        JTextField txtTitle = new JTextField();
        add(txtTitle);
        
        add(new JLabel(" Artist:"));
        JTextField txtArtist = new JTextField();
        add(txtArtist);
        add(new JLabel(" Year:"));
        JTextField txtYear = new JTextField();
        add(txtYear);

        add(new JLabel(" Gender:"));
        JTextField txtGender = new JTextField();
        add(txtGender);

        add(new JLabel(" Duration:"));
        JTextField txtDuration = new JTextField();
        add(txtDuration);

        add(new JLabel(" Label:"));
        JTextField txtLabel = new JTextField();
        add(txtLabel);

        add(new JLabel(" Country:"));
        JTextField txtCountry = new JTextField();
        add(txtCountry);

        add(new JLabel(" Color:"));
        JTextField txtColor = new JTextField();
        add(txtColor);

        add(new JLabel(" Price:"));
        JTextField txtPrice = new JTextField();
        add(txtPrice);
        
        add(new JLabel(" ¿Limited edition? (Y/N):"));
        JComboBox<String> cbLimited = new JComboBox<>(new String[]{"Y", "N"});
        add(cbLimited);
        
        JButton btnSave = new JButton(" Save");
        add(btnSave);
        
        add(new JLabel(""));
        
        setVisible(true);
        db = MongoConnection.ConnectToMongo();
        collection = db.getCollection("records");
        
        btnSave.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    VinylRecord record = new VinylRecord(
                    txtTitle.getText(),
                    txtArtist.getText(),
                    Integer.parseInt(txtYear.getText()),
                    txtGender.getText(),
                    txtDuration.getText(),
                    txtLabel.getText(),
                    txtCountry.getText(),
                    txtColor.getText(),
                    Float.parseFloat(txtPrice.getText()),
                    cbLimited.getSelectedItem().toString()
                    );
                    
                    Document doc = new Document("title", record.getTittle())
                            .append("artist", record.getArtist())
                            .append("year", record.getYear())
                            .append("gender", record.getGender())
                            .append("duration", record.getDuration())
                            .append("label", record.getLabel())
                            .append("country", record.getCountry())
                            .append("color", record.getColor())
                            .append("price", record.getPrice())
                            .append("limitedEdition", record.getLimitedEdition());
                    
                    collection.insertOne(doc);
                    
                    JOptionPane.showMessageDialog(null, "Record saved successfully!");

                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(null, "Year and Price must be numeric");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error saving record: " + ex.getMessage());
                }
            }
        });
    }
}
