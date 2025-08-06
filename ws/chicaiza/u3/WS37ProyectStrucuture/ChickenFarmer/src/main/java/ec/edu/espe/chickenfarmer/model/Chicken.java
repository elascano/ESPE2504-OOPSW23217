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
    String Chicken;
    String color;

    @Override
    public ArrayList<Chicken> readAll() {
        //validatins, buisness rules
        //using to read data frmo MongoDB Atlas
        return new ArrayList<Chicken>();
    }

    @Override
    public void assingCoop(ChickenCoop coop) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
