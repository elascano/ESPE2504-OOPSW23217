/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.chickenfarmer.controller;

import ec.edu.espe.chickenfarmer.model.Chicken;
import ec.edu.espe.chickenfarmer.model.ChickenCoop;
import java.util.ArrayList;

/**
 *
 * @author LABS-ESPE
 */
public abstract class ChickenController {
     public abstract ArrayList<Chicken> readAll();
     public abstract void assignCoop (Chicken chicken , ChickenCoop coop);
}
