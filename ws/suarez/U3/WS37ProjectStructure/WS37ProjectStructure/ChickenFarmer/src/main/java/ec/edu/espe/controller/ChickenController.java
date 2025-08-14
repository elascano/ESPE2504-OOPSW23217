package ec.edu.espe.controller;

import ec.edu.espe.model.Chicken;
import ec.edu.espe.model.ChickenCoop;
import java.util.ArrayList;

/**
 *
 * @author BERNARDO
 */

public abstract class ChickenController {
    
    public abstract ArrayList<Chicken> readAll();
    public abstract void assignCoop(Chicken chicken, ChickenCoop coop);
    
}
