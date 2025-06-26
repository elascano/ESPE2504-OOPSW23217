package ec.edu.espe.farm.model;

import java.util.Date;

/**
 *
 * @author Bonilla Caiza SoftCrafters
 */
public class Chicken extends FarmAnimal{
    private boolean isMolting;

    public Chicken(int id, String breed, Date bornOn, boolean isMolting) {
        super(id, breed, bornOn);
        this.isMolting = isMolting;
    }

    @Override
    public String toString() {
        return "Chicken{" + "isMolting=" + isMolting + '}';
    }

    @Override
    public void feed(Food food) {
System.out.println("Feeding chickens with: " + food);    
    }
    

}
