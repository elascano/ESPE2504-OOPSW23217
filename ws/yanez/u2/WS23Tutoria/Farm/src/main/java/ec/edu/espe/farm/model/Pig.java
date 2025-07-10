package ec.edu.espe.farm.model;

import java.util.Date;

/**
 *
 * @author Jose Yanez
 */
public class Pig extends FarmAnimal {

    public Pig(int id, String breed, Date bornOn) {
        super(id, breed, bornOn);
    }

    @Override
    public void feed(Food food) { //feed1
        System.out.println("Feeding a PIG with --> ." + food); 
    }
    
    //OverLoading
    public void feed(float food) { //feed2
        System.out.println("Other feed by weight --> " + food);
    }
    
    //OverLoading
    public void feed(Food food, int quantity) { //feed2
        System.out.println("Feeding a PIG with --> " + quantity + " of " + food);
    }    
}
