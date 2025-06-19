package ec.edu.espe.farm.model;

import java.util.Date;

/**
 *
 * @author LABS-ESPE
 */
public class Cow extends FarmAnimal {
    private boolean isProducingMilk;
    private float milkLittersPerDay;

    public Cow(boolean isProducingMilk, float milkLittersPerDay, int id, String breed, Date bornOn) {
        super(id, breed, bornOn);
        this.isProducingMilk = isProducingMilk;
        this.milkLittersPerDay = milkLittersPerDay;
    }

    @Override
    public String toString() {
        return "Cow{" + "isProducingMilk=" + isIsProducingMilk() + ", milkLittersPerDay=" + getMilkLittersPerDay() + '}';
    }

    

    @Override
    public void feed(Food food) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
     * @return the milkLittersPerDay
     */
    public float getMilkLittersPerDay() {
        return milkLittersPerDay;
    }

    /**
     * @param milkLittersPerDay the milkLittersPerDay to set
     */
    public void setMilkLittersPerDay(float milkLittersPerDay) {
        this.milkLittersPerDay = milkLittersPerDay;
    }
    
    
    
    
}
