package ec.edu.espe.farm.model;

import java.util.Date;

/**
 *
 * @author Quiroz Maria
 */
public class Sheep extends FarmAnimal {

    private Date lastSheering;
    private float woolLength;

    public Sheep(Date lastSheering, float woolLength, int id, String breed, Date bornOn) {
        super(id, breed, bornOn);
        this.lastSheering = lastSheering;
        this.woolLength = woolLength;
    }

    @Override
    public String toString() {
        return "Sheep{" + super.toString() + "lastSheering=" + lastSheering + ", woolLength=" + woolLength + '}';
    }

    @Override
    public void feed(Food food) {
        System.out.println("feeding sheeps with " + food);
    }

    /**
     * @return the lastSheering
     */
    public Date getLastSheering() {
        return lastSheering;
    }

    /**
     * @param lastSheering the lastSheering to set
     */
    public void setLastSheering(Date lastSheering) {
        this.lastSheering = lastSheering;
    }

    /**
     * @return the woolLength
     */
    public float getWoolLength() {
        return woolLength;
    }

    /**
     * @param woolLength the woolLength to set
     */
    public void setWoolLength(float woolLength) {
        this.woolLength = woolLength;
    }

}
