package ec.edu.espe.farm.model;

import java.util.Date;

/**
 *
 * @author Quiroz Maria
 */
public class Pig extends FarmAnimal {

    private float mudLevel;

    public Pig(float mudLevel, int id, String breed, Date bornOn) {
        super(id, breed, bornOn);
        this.mudLevel = mudLevel;
    }

    @Override
    public String toString() {
        return "Pig{" + super.toString() + "mudLevel=" + mudLevel + '}';
    }

    @Override
    public void feed(Food food) {
        System.out.println("feeding pigs with " + food);
    }

    /**
     * @return the mudLevel
     */
    public float getMudLevel() {
        return mudLevel;
    }

    /**
     * @param mudLevel the mudLevel to set
     */
    public void setMudLevel(float mudLevel) {
        this.mudLevel = mudLevel;
    }

}
