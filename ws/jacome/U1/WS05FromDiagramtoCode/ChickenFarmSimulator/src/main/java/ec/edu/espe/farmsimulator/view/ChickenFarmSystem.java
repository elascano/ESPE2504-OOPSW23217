package ec.edu.espe.farmsimulator.view;

import ec.edu.espe.farmsimulator.model.Egg;
import ec.edu.espe.farmsimulator.model.Poop;


/**
 *
 * @author Micaela Jacome DESKTOP-46VMNHU ESPE
 */
public class ChickenFarmSystem {
    
    public static void main(String[] args) {
        System.out.println("This is a Chciken Farm Simulator");
        Poop poop;
        Egg egg; 
        Egg egg2;
        Egg egg3;
        int numberOfTires;
        String name;
                
        egg= new Egg();
        egg2 = new Egg();
        egg3 = new Egg();
        poop = new Poop();
        numberOfTires = 5;
        name = "Micaela";


        System.out.println("The number of tires is --> " + numberOfTires);
        System.out.println("Chicken poop is --> " + poop);
        System.out.println("my name is --> " + name);
        
        egg.setId(1);
        System.out.println("Chicken egg is --> " + egg);
        System.out.println("Chicken egg id is --> "+ egg.getId());
        
        egg.setId(2);
        System.out.println("Chicken egg is --> " + egg2);
        System.out.println("Chicken egg id is --> "+ egg.getId());
        
        egg.setId(3);
        System.out.println("Chicken egg is --> " + egg3);
        System.out.println("Chicken egg id is --> "+ egg.getId());
        
    }
}
