package ec.edu.espe.farmsimulator.view;

import ec.edu.espe.farmsimulator.model.Egg;
import ec.edu.espe.farmsimulator.model.Poop;
import java.util.HashSet;

/**
 *
 * @author Gerald Astudillo SoftCrafters DCCO ESPE
 */
public class ChickenFarmSystem {

    public static void main(String args[]) {

        Poop poop;
        int numberOfTires;
        Egg egg;
        Egg egg2;
        Egg egg3;
        String name;

        poop = new Poop();
        egg = new Egg();
        egg2 = new Egg();
        egg3 = new Egg();
        numberOfTires = 5;
        name = "Gerald";

        System.out.println("This a Chicken Farm Simulator");
        System.out.println("the number of Tires is " + numberOfTires);
        poop.setId(1);
        System.out.println("the number of Poops is " + poop);
        System.out.println("the number of Poops is " + poop.getId());
        System.out.println("My Name is " + name);
        egg.setId(1);
        System.out.println("Chicken egg is " + egg);
        System.out.println("Chicken egg id is " + egg.getId());
        egg2.setId(2);
        System.out.println("Chicken egg is " + egg2);
        System.out.println("Chicken egg id is " + egg2.getId());
        egg3.setId(3);
        System.out.println("Chicken egg is " + egg3);
        System.out.println("Chicken egg id is " + egg3.getId());

    }
}
