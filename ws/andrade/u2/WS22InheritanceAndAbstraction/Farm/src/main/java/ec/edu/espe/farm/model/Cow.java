package ec.edu.espe.farm.model;

import java.util.Date;

/**
 *
 * @author Bonilla David Softcrafters
 */
public class Cow extends FarmAnimal {

    private boolean isProducingMilk;
    private float milkProduction;

    public Cow(boolean isProducingMilk, float milkProduction, int id, String breed, Date bornOn) {
        super(id, breed, bornOn);
        this.isProducingMilk = isProducingMilk;
        this.milkProduction = milkProduction;
    }

    @Override
    public String toString() {
        return "Cow{" + super.toString() + "isProducingMilk=" + isProducingMilk + ", milkProduction=" + milkProduction + '}';
    }

    @Override
    public void feed(Food food) {
        System.out.println("feeding cow with " + food);
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
     * @return the milkProduction
     */
    public float getMilkProduction() {
        return milkProduction;
    }

    /**
     * @param milkProduction the milkProduction to set
     */
    public void setMilkProduction(float milkProduction) {
        this.milkProduction = milkProduction;
    }

}
