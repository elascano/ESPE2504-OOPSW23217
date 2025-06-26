
package espe.edu.ec.view.model;

import java.util.Date;

/**
 *
 * @author Isaac Maisincho
 */
public class Cow extends FarmAnimal {

    private float milkProduction; // in liters/day

    public Cow(float milkProduction, int id, String breed, Date bornOn) {
        super(id, breed, bornOn);
        this.milkProduction = milkProduction;
    }

    @Override
    public void feed(Food food) {
        System.out.println("Feeding cow with " + food);
    }

    @Override
    public String toString() {
        return "Cow{" + super.toString() + "milkProduction=" + milkProduction + "L/day}";
    }

    public float getMilkProduction() {
        return milkProduction;
    }

    public void setMilkProduction(float milkProduction) {
        this.milkProduction = milkProduction;
    }
}
