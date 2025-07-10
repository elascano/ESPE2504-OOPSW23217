package ec.edu.espe.farm.model;

import ec.edu.espe.farm.controller.IMammal;
import java.util.Date;

/**
 *
 * @author Chicaiza Michael
 */
public class Cow extends FarmAnimal implements IMammal {

    private boolean isProducingMilk;
    private float milkProduction;
    private int numberOfNipples;

    public Cow(boolean isProducingMilk, float milkProduction, int numberOfNipples, int id, String breed, Date bornOn) {
        super(id, breed, bornOn);
        this.isProducingMilk = isProducingMilk;
        this.milkProduction = milkProduction;
        this.numberOfNipples = numberOfNipples;
    }

    @Override
    public String toString() {
        return "Cow{" + super.toString() + "isProducingMilk=" + isIsProducingMilk() + ", milkProduction=" + getMilkProduction() + '}';
    }

    @Override
    public void feed(Food food) {
        System.out.println("feeding a cow");
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

    /**
     * @return the numberOfNipples
     */
    public int getNumberOfNipples() {
        return numberOfNipples;
    }

    /**
     * @param numberOfNipples the numberOfNipples to set
     */
    public void setNumberOfNipples(int numberOfNipples) {
        this.numberOfNipples = numberOfNipples;
    }

    @Override
    public float breastfeed(float QuantilyOfNipples) {
        System.out.println("breastfeeding a cow");
        return QuantilyOfNipples / 2;
    }

    @Override
    public float controlGestation(int periodInDays) {
        System.out.println("Crontoling a cow avery " + periodInDays + " days ");
        return periodInDays * 2;
    }

}
