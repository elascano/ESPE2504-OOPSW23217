package ec.espe.edu.question33.controller;

import ec.espe.edu.question33.model.Cellphone;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
/**
 *
 * @author Bonilla Caiza SoftCrafters
 */
public class FileManagerCellphone {
    
    private static final String     fileCellphone  = "src/ec/edu/espe/eduplan/files/ListCellphone.csv";

    public static void saveCellphoneToCSV(Cellphone cellphone) {
        try (FileWriter writer = new FileWriter(fileCellphone , true)) {
            writer.write(cellphone.toString() + "\n");
            System.out.println("Actividad guardada con exito.");
        } catch (IOException e) {
            System.err.println("Error al guardar la actividad, intenta nuevamente.");
        }
    }
}
