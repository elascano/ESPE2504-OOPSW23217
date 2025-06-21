
package espe.edu.ec.view.model;

import java.util.Date;

/**
 *
 * @author Isaac Maisincho 
 */
public class Pig extends FarmAnimal {

    private float weight;

    public Pig(float weight, int id, String breed, Date bornOn) {
        super(id, breed, bornOn);
        this.weight = weight;
    }

    @Override
    public void feed(Food food) {
        System.out.println("Feeding pig with " + food);
    }

    @Override
    public String toString() {
        return "Pig{" + super.toString() + "weight=" + weight + "kg}";
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}
