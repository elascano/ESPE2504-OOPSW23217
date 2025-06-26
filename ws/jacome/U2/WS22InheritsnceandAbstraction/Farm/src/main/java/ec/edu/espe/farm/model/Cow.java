package ec.edu.espe.farm.model;

import java.util.Date;
/**
 *
 * @author LABS-ESPE
 */

public class Cow extends FarmAnimal {
    private boolean isProducingMilk;
    private int moo;

    // Constructor
    public Cow(boolean isProducingMilk, int moo, int id, String breed, Date bornOn, float weight) {
        super(id, breed, bornOn, weight);
        this.isProducingMilk = isProducingMilk;
        this.moo = moo;
    }

    // Getters y Setters
    public boolean isProducingMilk() {
        return isProducingMilk;
    }

    public void setProducingMilk(boolean isProducingMilk) {
        this.isProducingMilk = isProducingMilk;
    }

    public int getMoo() {
        return moo;
    }

    public void setMoo(int moo) {
        this.moo = moo;
    }

    // Método específico
    public int countMilkProduced() {
        return moo * 10;
    }

    @Override
    public void feed(Food food) {
        System.out.println("Feeding cow with " + food);
    }

    @Override
    public String toString() {
        return "Cow{" + super.toString() + ", isProducingMilk=" + isProducingMilk + ", moo=" + moo + '}';
    }
}