package ec.edu.espe.farmsimulator.view;

import ec.edu.espe.farmsimulator.model.Egg;
import ec.edu.espe.farmsimulator.model.Poop;
import java.util.HashSet;

/**
 *
 * @author Michael Chicaiza SOFTCRAF DCCO ESPE
 */
public class ChickenFarmSystem {

    public static void main(String[] args) {
        System.out.println("This is a Chicken Farm Simulator");
        Poop poop;
        Poop poop2;
        Poop poop3;
        Egg egg;
        Egg egg2;
        Egg egg3;
        int numberOfTires;
        String name;

        egg = new Egg();
        egg2 = new Egg();
        egg3 = new Egg();
        poop = new Poop();
        poop2=new  Poop();
        poop3=new Poop();
        numberOfTires = 5;
        name = "Michael";

        System.out.println("The namber of tires is -->" + numberOfTires);
        poop.setId(1);
        poop2.setId(2);
        poop3.setId(6);
        System.out.println("Chicken poop is-->" + poop);
        System.out.println("Chicken poop is -->" + poop.getId());
        System.out.println("Chicken poop is -->" + poop2.getId());
        System.out.println("Chicken poop is -->" + poop3.getId());
        System.out.println("Mi name is -->" + name);
        egg.setId(1);
        egg2.setId(2);
        egg3.setId(4);
        System.out.println("Chicken -->" + egg);
        System.out.println("Chicken egg 1-->" + egg.getId());
        System.out.println("Chicken egg 2-->" + egg2.getId());
        System.out.println("Chicken egg 3-->" + egg3.getId());
    }
}
