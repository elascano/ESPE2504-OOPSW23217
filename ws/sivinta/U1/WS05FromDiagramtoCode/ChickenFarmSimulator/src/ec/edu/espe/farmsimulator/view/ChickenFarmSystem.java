package ec.edu.espe.farmsimulator.view;

import ec.edu.espe.farmsimulator.model.Egg;
import ec.edu.espe.farmsimulator.model.Poop;

/**
 *
 * @author Jahir Sivinta Jsnow DCCO ESPE
 */
public class ChickenFarmSystem {

    public static void main(String args[]) {
        System.out.println("This is a chicken farm simulator");

        Poop poop;
        Egg egg;
        int numberOfTires;
        String name;
        Egg egg2;
        Egg egg3;
        
        poop = new Poop();
        numberOfTires = 5;
        egg = new Egg();
        egg2 = new Egg();
        egg3 = new Egg();
        name = "Jahir";

        System.out.println("The number of tires is --> " + numberOfTires);
        poop.setId(1);
        System.out.println("Chicken poop is -->" + poop.getId());
        System.out.println("My name is --> " + name);
        egg.setId(1);
        System.out.println("Chicken egg id is --> " + egg.getId());
          egg.setId(2);
        System.out.println("Chicken egg id is --> " + egg.getId());
          egg.setId(3);
        System.out.println("Chicken egg id is --> " + egg.getId());
    }
}
