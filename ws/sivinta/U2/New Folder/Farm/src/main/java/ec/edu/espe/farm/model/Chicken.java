package ec.edu.espe.farm.model;

import java.util.Date;

/**
 *
 * @author LABS-ESPE
 */
public class Chicken extends FarmAnimal{ 

    /**
     * @return the isMolting
     */
    public boolean isIsMolting() {
        return isMolting;
    }

    /**
     * @param isMolting the isMolting to set
     */
    public void setIsMolting(boolean isMolting) {
        this.isMolting = isMolting;
    }
    
    private boolean isMolting;

    public Chicken(int id, String breed, Date bornOn, boolean isMolting) {
        super(id, breed, bornOn);
        this.isMolting = isMolting;
    }
    
    @Override
    public void feed(Food food) {
        System.out.println("Feeding chickens with " + food);
    }

    @Override
    public String toString() {
        return "Chicken{" + "isMolting=" + isMolting + '}';
    }
    
}
