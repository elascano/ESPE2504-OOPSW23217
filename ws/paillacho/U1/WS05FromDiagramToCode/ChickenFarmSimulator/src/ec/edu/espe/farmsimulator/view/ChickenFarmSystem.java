package ec.edu.espe.farmsimulator.view;

import ec.edu.espe.farmsimulator.model.Egg;
import ec.edu.espe.farmsimulator.model.Poop;


/**
 *
 * @author Carlos Paillacho < team3>
 */
public class ChickenFarmSystem {

    public static void main(String[] args) {
        System.out.println("This is a Chicken Farm Simulator");
        Poop poop;
        Egg egg;
        int numberOfTires;
        String name;
        
        egg = new Egg();
        poop = new Poop();
        numberOfTires = 5;
        name = "Edison";
    
        System.out.println("The number of tires is --> " + numberOfTires);
        System.out.println("Chicken poop is --> " + poop);
        System.out.println("My name is --> " + name);
    }    
    

}
    
