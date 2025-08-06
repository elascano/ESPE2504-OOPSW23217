/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.chickenfarmer.model;

import ec.edu.espe.chickenfarmer.controller.ChickenController;
import java.util.ArrayList;

/**
 *
 * @author LABS-ESPE
 */
public class Chicken extends ChickenController{
    
    int id;
    String BornOnDate;
    boolean isMolting;
    String color;

    @Override
    public ArrayList<Chicken> readAll() {
        //validation, buisness rules
        //using utils to read data from MongoDb Atlas
        return new ArrayList<Chicken>();
    }

    @Override
    public void assignCoop(Chicken chicken, ChickenCoop coop) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
