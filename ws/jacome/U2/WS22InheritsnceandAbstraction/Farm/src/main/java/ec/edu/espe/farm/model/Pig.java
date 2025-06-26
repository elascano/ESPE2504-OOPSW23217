package ec.edu.espe.farm.model;

import java.util.Date;

/**
 *
 * @author LABS-ESPE
 */
public class Pig extends FarmAnimal {
    private boolean mud;

    // Constructor
    public Pig(boolean mud, int id, String breed, Date bornOn, float weight) {
        super(id, breed, bornOn, weight);
        this.mud = mud;
    }

    // Getters y Setters
    public boolean isMud() {
        return mud;
    }

    public void setMud(boolean mud) {
        this.mud = mud;
    }

    // Método específico
    public boolean rootInMud() {
        return mud;
    }

    @Override
    public void feed(Food food) {
        System.out.println("Feeding pig with " + food);
    }

    @Override
    public String toString() {
        return "Pig{" + super.toString() + ", mud=" + mud + '}';
    }
}