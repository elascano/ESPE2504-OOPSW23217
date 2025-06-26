package ec.edu.espe.farm.model;

import java.util.Date;

/**
 *
 * @author LABS-ESPE
 */
public class Chicken extends FarmAnimal {

    private boolean isMolting;
    private int egg;

    public Chicken(int id, String breed, Date bornOn, boolean isMolting, float weight) {
        super(id, breed, bornOn, weight); 
        this.isMolting = isMolting;
    }

    @Override
    public String toString() {
        return "Chicken{" + super.toString() + "isMolting=" + isMolting + '}';
    }

    @Override
    public void feed(Food food) {
        System.out.println("feeding chickens with" + food);
    }

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

}
