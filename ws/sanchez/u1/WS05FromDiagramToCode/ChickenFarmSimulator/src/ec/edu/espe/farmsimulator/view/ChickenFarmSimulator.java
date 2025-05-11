package ec.edu.espe.farmsimulator.view;

import ec.edu.espe.farmsimulator.model.Egg;
import ec.edu.espe.farmsimulator.model.Poop;


/**
 *
 * @author Yesteb JSnow
 */
public class ChickenFarmSimulator {
   
    public static void main(String[] args) {
        System.out.println("This is a ChickenFarm");
        Poop poop;
        Egg egg;
        Egg egg2;
        Egg egg3;
        Egg egg4;
        
        int numberOfTypes;
        String name;
        
        poop = new Poop();
        egg = new Egg();
        egg2 = new Egg();
        egg3 = new Egg();
        egg4 = new Egg();
        numberOfTypes = 5;
        name = "Julio";
        
        System.out.println("The number of tires is --> " + numberOfTypes);
        poop.setId(32);
        System.out.println("Chicken poop is -->" + poop);
        System.out.println("Chicken poop id is -->" + poop.getId());
   
        System.out.println("My name is --> " + name);
        
        egg.setId(1);
        System.out.println("Chicken egg is --> " + egg);
        System.out.println("Chicken egg id is --> " + egg.getId());
        
        egg2.setId(32);
        System.out.println("Chicken second egg is --> " + egg);
        System.out.println("Chicken second egg id is --> " + egg.getId());
        
        egg3.setId(23);
        System.out.println("Chicken third egg is --> " + egg);
        System.out.println("Chicken third egg id is --> " + egg.getId());
        
        egg4.setId(53);
        System.out.println("Chicken fourth egg is --> " + egg);
        System.out.println("Chicken fourth egg id is --> " + egg.getId());
        
        
        
    }
}
