
package ec.edu.espe.farm.model;

import java.util.Date;

/**
 *
 * @author Sanchez Julio
 */
public class Chicken extends FarmAnimal{
    
    private boolean isMolting;
    private int numberOfEggs;
    
    public Chicken(boolean isMolting, int id, String breed, Date bornOn, int numberOfEggs) {
        super(id, breed, bornOn);
        this.isMolting = isMolting;
    }

    @Override
    public String toString() {
        return "Chicken{" + super.toString() +"isMolting=" + isMolting + "numberOfEggs="+ numberOfEggs + '}';
    }
    
    
    @Override
    public void feed(Food food) {
        System.out.println("Feeding chickens with " + food);
               
    }
    public int addEgg(){
        numberOfEggs++;
        return numberOfEggs;
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

    /**
     * @return the numberOfEggs
     */
    public int getNumberOfEggs() {
        return numberOfEggs;
    }

    /**
     * @param numberOfEggs the numberOfEggs to set
     */
    public void setNumberOfEggs(int numberOfEggs) {
        this.numberOfEggs = numberOfEggs;
    }
    
}
