package ec.edu.espe.farmsimulator.view;

import ec.edu.espe.farmsimulator.model.Egg;
import ec.edu.espe.farmsimulator.model.Poop;

/**
 *
 * @author José Yánez
 */
public class ChickenFarmSystem {

    public static void main(String[] args) {
        System.out.println("This is a Chicken Farm Simulator.");
        Poop poop;
        Poop poop2;
        Poop poop3;
        Egg egg;
        Egg egg2;
        Egg egg3;
        int numberOfTires;
        String name;
        
        poop = new Poop();
        poop2 = new Poop();
        poop3 = new Poop();
        egg = new Egg();
        egg2 = new Egg(); 
        
        egg3 = new Egg(); 
        numberOfTires=5;
        name="Jose";
        
        System.out.println("The number of tires is --> " + numberOfTires);
        poop.setId(7);
        System.out.println("Chicken poop is --> " + poop.getId());
        System.out.println("My name is --> " + name);
        egg.setId(1);
        System.out.println("Chicken egg is -->" + egg.getId());
        egg2.setId(20);
        System.out.println("Chicken egg2 is -->" + egg2.getId());

   
    }
}