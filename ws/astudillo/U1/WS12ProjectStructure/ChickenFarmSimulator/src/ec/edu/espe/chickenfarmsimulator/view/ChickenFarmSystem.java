package ec.edu.espe.chickenfarmsimulator.view;

import ec.edu.espe.chickenfarmsimulator.model.Egg;
import ec.edu.espe.chickenfarmsimulator.model.Poop;

/**
 *
 * @author Gerald Astudillo SoftCrafters DCCO ESPE
 */

public class ChickenFarmSystem {
    public static void main(String args[]){
        
        System.out.println("This is a Chicken Farm Simulator");
        
        //Declare
        Poop poop;
        Egg egg;
        Egg egg2;
        Egg egg3;
        int numberOfTires;
        String name;
        
        //Initialize
        poop = new Poop();
        egg = new Egg();
        egg2 = new Egg();
        egg3 = new Egg();
        numberOfTires=5;
        name= "David";
        
        //Methods
        System.out.println("The number of tires is --->" + numberOfTires);
        System.out.println("Chicken poop is -->" + poop);
        System.out.println("My name is  --> "+name);
        egg.setId(1);
        System.out.println("Chicken egg is -->" + egg);
        System.out.println("Ciucken egg id is --> " + egg.getId());
        egg.setId(2);
        System.out.println("Chicken egg is -->" + egg2);
        System.out.println("Ciucken egg id is --> " + egg.getId());
        egg.setId(3);
        System.out.println("Chicken egg is -->" + egg3);
        System.out.println("Ciucken egg id is --> " + egg.getId());
    }
}
