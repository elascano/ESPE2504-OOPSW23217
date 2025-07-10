package ec.edu.espe.farm.model;

import java.util.Date;

/**
 *
 * @author LABS-ESPE
 */
public class Pig extends FarmAnimal{

    public Pig(int id, String breed, Date bornOn) {
        super(id, breed, bornOn);
    }
    
    @Override
    public void feed(Food food) {
        System.out.println("feeding a PIG with --> " + food);
    }
    
    public void feed(float food){
        System.out.println("other feed by weight --> " + food);
    }
    
    public void feed(Food food, int quantity){
        System.out.println("feeding a PIG with --> " + quantity + "of" + food);
    }
    
}
