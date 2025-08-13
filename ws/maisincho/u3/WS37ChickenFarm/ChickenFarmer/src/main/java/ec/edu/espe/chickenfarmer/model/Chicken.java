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
        //Validation buisness rules
        //Using utils to read data from mongo
        return new ArrayList<Chicken>();
        
    }

    @Override
    public void assignCoop(ChickenCoop coop) {
        
    }
}
