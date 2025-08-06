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
    String Color;

    @Override
    public ArrayList<Chicken> readAll() {
       
       
    }   
}

    @Override
    public void assignCoop(Chicken chicken, ChickenCoop coop){
}