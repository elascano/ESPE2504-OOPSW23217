package ec.edu.espe.model;

import ec.edu.espe.controller.ChickenController;
import java.util.ArrayList;

/**
 *
 * @author BERNARDO
 */
public class Chicken extends ChickenController {
    
    int id;
    String BornOnDate;
    boolean isMolting;
    String color;

    @Override
    public ArrayList<Chicken> readAll() {
        
        //validations, business rules
        //using utils to read data from MongoDBAtlas
        return new ArrayList<Chicken>();
        
    }

    @Override
    public void assignCoop(Chicken chicken, ChickenCoop coop) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
