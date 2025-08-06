
package ec.edu.espe.chickenfarm.model;

import ec.edu.espe.chickenfarm.controller.ChickenController;
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
    public ArrayList<Chicken> readAll(){
        return new ArrayList<>();
    }
    
    @Override
    public void assignCoop(Chicken chicke, ChickenCoop coop){
        throw new UnsupportedOperationException("Not supported yet");
    }
}
