package ec.edu.espe.farmsimulator.view;

import ec.edu.espe.farmsimulator.model.Egg;
import ec.edu.espe.farmsimulator.model.Poop;

/**
 *
 * @author Gabriela Araujo UTPL
 */
public class ChickenFarmSystem {

    public static void main(String args[]) {
        System.out.println("This is a Chicken Farm Simulator");
        Egg egg;
        Egg egg2;
        Egg egg3;
        Poop poop;
        Poop poop2;
        Poop poop3;
        int numberOfTires;
        String name;

        poop = new Poop();
        poop2 = new Poop();
        poop3 = new Poop();
        egg = new Egg();
        egg2= new Egg();
        egg3= new Egg();

        numberOfTires = 5;
        name="Bernardo";
                
        System.out.println("The number of tires is --> " + numberOfTires);
        System.out.println("Chicken Poop is --> " + poop);
        System.out.println("My name is --> " + name);
        egg.setId(1);
        egg.setId(2);
        egg.setId(3);

        System.out.println("Chicken egg id is--> " + egg.getId());
    }
}
