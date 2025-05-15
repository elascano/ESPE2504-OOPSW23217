package ec.edu.espe.farmsimulator.view;

import ec.edu.espe.farmsimulator.model.Egg;
import ec.edu.espe.farmsimulator.model.Poop;

/**
 *
 * @author Tammy Caizapanta SoftCrafters DCCO ESPE
 */

public class ChickenFarmSystem {

    public static void main(String args[]) {
        System.out.println("This is a Chicken Farm Simulator");
        Poop poop, poop1, poop2, poop3;
        Egg egg, egg1, egg2, egg3;
        int numberOfTires;
        String name;

        poop = new Poop();
        poop1 = new Poop();
        poop2 = new Poop();
        poop3 = new Poop();

        egg = new Egg();
        egg1 = new Egg();
        egg2 = new Egg();
        egg3 = new Egg();
        numberOfTires = 5;
      
        name = "Tammy";

        System.out.println("The number of tires is -->" + numberOfTires);

        poop.getId();
        System.out.println("Chicken poop is --> " + poop);
        System.out.println("Chicken poop id is --> " + poop.getId());
        poop1.setId(1);
        System.out.println("Chicken poop 1 is --> " + poop1);
        System.out.println("Chicken poop 1 id is --> " + poop1.getId());
        poop2.setId(2);
        System.out.println("Chicken poop 2 is --> " + poop2);
        System.out.println("Chicken poop 2 id is --> " + poop2.getId());
        poop3.setId(3);
        System.out.println("Chicken poop 3 is --> " + poop3);
        System.out.println("Chicken poop 3 id is --> " + poop3.getId());

        System.out.println("My name is --> " + name);

        egg.getId();
        System.out.println("Chicken egg is --> " + egg);
        System.out.println("Chicken egg id is --> " + egg.getId());
        egg1.setId(1);
        System.out.println("Chicken egg 1 is --> " + egg1);
        System.out.println("Chicken egg 1 id is --> " + egg1.getId());
        egg2.setId(2);
        System.out.println("Chicken egg 2 is --> " + egg2);
        System.out.println("Chicken egg 2 id is --> " + egg2.getId());
        egg3.setId(3);
        System.out.println("Chicken egg 3 is --> " + egg3);
        System.out.println("Chicken egg 3 id is --> " + egg3.getId());

    }
}