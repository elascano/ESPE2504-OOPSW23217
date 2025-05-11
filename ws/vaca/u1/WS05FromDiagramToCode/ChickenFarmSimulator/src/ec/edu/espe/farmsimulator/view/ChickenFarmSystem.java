package ec.edu.espe.farmsimulator.view;

import ec.edu.espe.farmsimulator.model.Egg;
import ec.edu.espe.farmsimulator.model.Poop;

/**
 *
 * @author Kevin Vaca Edison's OOP ESPE
 */
public class ChickenFarmSystem {

    public static void main(String[] args) {
        System.out.println("This is a Chicken Farm Simulator.");
        Poop poop;
        Egg egg;
        Egg egg2;
        Egg egg3;
        int numberOfTires;
        String name;
        
        egg = new Egg();
        egg2 = new Egg();
        egg3= new Egg();
        poop = new Poop();        
        numberOfTires=5;
        name="Kevin";
        
        System.out.println("The number of tires is --> " + numberOfTires);
        poop.setId(7);
        System.out.println("Chicken poop is --> " + poop.getId());
        System.out.println("My name is --> " + name);
        egg.setId(21);
        System.out.println("Chicken egg is -->" + egg.getId());
        egg2.setId(22);
        System.out.println("Chicken egg2 is -->" + egg2.getId());
        egg3.setId(23);
        System.out.println("Chicken egg2 is -->" + egg3.getId());

   
    }
}