
package ec.edu.espe.farm.model;

import java.util.Date;

/**
 *
 * @author Sanchez Julio
 */
public class Cow extends FarmAnimal{

    private boolean isProducingMilk;
    private int numberOfLiter;

    public Cow(boolean isProducingMilk, int numberOfLiter, int id, String breed, Date bornOn) {
        super(id, breed, bornOn);
        this.isProducingMilk = isProducingMilk;
        this.numberOfLiter = numberOfLiter;
    }

    @Override
    public String toString() {
        return "Cow{" + "isProducingMilk=" + isProducingMilk + ", numberOfliter=" + numberOfLiter + '}';
    }
    
    public int addMilkOfLiter (){
        numberOfLiter++;
        return numberOfLiter;
    }
    
    /**
     * @return the isProducingMilk
     */
    public boolean isIsProducingMilk() {
        return isProducingMilk;
    }

    /**
     * @param isProducingMilk the isProducingMilk to set
     */
    public void setIsProducingMilk(boolean isProducingMilk) {
        this.isProducingMilk = isProducingMilk;
    }

    /**
     * @return the numberOfliter
     */
    public int getNumberOfliter() {
        return numberOfLiter;
    }

    /**
     * @param numberOfliter the numberOfliter to set
     */
    public void setNumberOfliter(int numberOfliter) {
        this.numberOfLiter = numberOfliter;
    }

    @Override
    public void feed(Food food) {
       System.out.println("Feeding cow with " + food);
    }
    
    
}
