package ec.edu.espe.farm.model;

import java.util.Date;

/**
 *
 * @author Carlos Paillacho
 */
public class Pig extends FarmAnimal {

    private float weight;

    public Pig(int id, String breed, Date bornOn, float weight) {
        super(id, breed, bornOn);
        this.weight = weight;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return super.toString() + ", Pig{" + "weight=" + weight + "kg}";
    }
}
