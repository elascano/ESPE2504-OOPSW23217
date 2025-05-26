
package ec.edu.espe.view;

import ec.edu.espe.model.Egg;
import ec.edu.espe.model.Poop;

/**
 *
 * @author Isaac Maisincho 
 */
public class ChickenFarmSystem {
    public static void main(String args[]){
        
        System.out.println("This is a Chicken Farm Simulator");
        
    
        Poop poop;
        Egg egg;
        Egg eggTwo;
        Egg eggThree;
        int numberOfTires;
        String name;
        
      
        poop = new Poop();
        egg = new Egg();
        eggTwo = new Egg();
        eggThree = new Egg();
        numberOfTires=5;
        name= "David";
        
        
        System.out.println("The number of tires is --->" + numberOfTires);
        System.out.println("Chicken poop is -->" + poop);
        System.out.println("My name is  --> "+name);
        egg.setId(1);
        System.out.println("Chicken egg is -->" + egg);
        System.out.println("Ciucken egg id is --> " + egg.getId());
        egg.setId(2);
        System.out.println("Chicken egg is -->" + eggTwo);
        System.out.println("Ciucken egg id is --> " + egg.getId());
        egg.setId(3);
        System.out.println("Chicken egg is -->" + eggThree);
        System.out.println("Ciucken egg id is --> " + egg.getId());
    }
}
