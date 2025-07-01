
package ec.edu.espe.farm.model;

import java.util.Date;

/**
 *
 * @author Sanchez Julio
 */
public class Pig extends FarmAnimal{
    
    private float weight;
    private boolean isTimeToSex; 

    public Pig(float weight, boolean isTimeToSex, int id, String breed, Date bornOn) {
        super(id, breed, bornOn);
        this.weight = weight;
        this.isTimeToSex = isTimeToSex;
    }

    


    @Override
    public String toString() {
        return "Pig{" + "weight=" + weight + ", isTimeToSex=" + isTimeToSex + '}';
    }
    
    public void TimeToSex(){
        System.out.println("The pig going to has a lot sex...");
    }
    
    /**
     * @return the weight
     */
    public float getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(float weight) {
        this.weight = weight;
    }

    /**
     * @return the isTimeToSex
     */
    public boolean isIsTimeToSex() {
        return isTimeToSex;
    }

    /**
     * @param isTimeToSex the isTimeToSex to set
     */
    public void setIsTimeToSex(boolean isTimeToSex) {
        this.isTimeToSex = isTimeToSex;
    }

    @Override
    public void feed(Food food) {
        System.out.println("Feeding pig with " + food);
    }
    
    
}
