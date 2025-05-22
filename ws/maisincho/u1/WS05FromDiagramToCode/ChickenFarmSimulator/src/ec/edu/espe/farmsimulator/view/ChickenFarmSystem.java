package ec.edu.espe.farmsimulator.view;

import ec.edu.espe.farmsimulator.model.Egg;
import ec.edu.espe.farmsimulator.model.Poop;

/**
 *
 * @author Isaac Maisincho Crafters_Market DCCO ESPE
 */
public class ChickenFarmSystem {

    public static void main(String args[]) {
        System.out.println("This is a Chicken Farm Simulator");
        Poop poop;
        Poop poop1;
        Poop poop2;
        Egg egg;
        Egg egg1;
        Egg egg2;
        String name;
        int numberOfTires;

        numberOfTires = 5;
        name = "Isaac ";
        poop = new Poop();
        egg = new Egg();
        egg1 = new Egg();
        egg2= new Egg();
        poop1 = new Poop();
        poop2 = new Poop();

        System.out.println("The number of tires is --> " + numberOfTires);
        poop.setId(5);
        poop1.setId(8);
        poop2.setId(4);
        System.out.println("Chicken poop is --> " + poop.getId());
        System.out.println("Chicken poop is --> " + poop1.getId());
        System.out.println("Chicken poop is --> " + poop2.getId());
        System.out.println("My name is : " + name);
        egg.setId(1);
        egg.setId(3);
        egg.setId(4);
        System.out.println("Chicken egg is-->:" + egg.getClass());
        System.out.println("Chicken egg is-->:" + egg1.getClass());
        System.out.println("Chicken egg is-->:" + egg2.getClass());
    }
}
