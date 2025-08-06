
package ec.edu.espe.chickenfarm.controller;

import ec.edu.espe.chickenfarm.model.Chicken;
import ec.edu.espe.chickenfarm.model.ChickenCoop;
import java.util.ArrayList;

/**
 *
 * @author LABS-ESPE
 */
public abstract class ChickenController {
    public abstract ArrayList<Chicken> readAll();
    public abstract void assignCoop(Chicken chicken ,ChickenCoop coop);
    
}
