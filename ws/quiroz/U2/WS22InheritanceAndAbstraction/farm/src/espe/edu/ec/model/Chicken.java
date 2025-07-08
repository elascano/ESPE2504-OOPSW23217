package ec.edu.espe.farm.model;

import java.util.Date;

/**
 *
 * @author Quiroz Maria
 */
public class Chicken extends FarmAnimal {

    private boolean isMolting;
    private int numberOfEggs;

    public Chicken(boolean isMolting, int numberOfEggs, int id, String breed, Date bornOn) {
        super(id, breed, bornOn);
        this.isMolting = isMolting;
        this.numberOfEggs = numberOfEggs;
    }

    @Override
    public void feed(Food food) {
        System.out.println("feeding chickens with " + food);
    }

    @Override
    public String toString() {
        return "Chicken{" + super.toString() + "isMolting=" + isMolting + ", numberOfEggs=" + numberOfEggs + '}';
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
