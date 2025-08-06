package ec.edu.espe.chickenfarmer.model;

import ec.edu.espe.chickenfarmer.controller.ChickenController;
import java.util.ArrayList;

/**
 *
 * @author LABS-ESPE
 */
public class Chicken extends ChickenController{
    int id;
    String bornOnDate;
    boolean isMolting;
    String color;

    @Override
    public ArrayList<Chicken> readAll() {
        //validations, business rules
        //using utils to read data from mongoDB atlas
        return new ArrayList<Chicken>();
    }

    @Override
    public void assignCoop(ChickenCoop coop) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
