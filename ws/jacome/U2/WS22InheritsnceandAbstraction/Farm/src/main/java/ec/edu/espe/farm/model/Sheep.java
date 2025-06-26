package ec.edu.espe.farm.model;

import java.util.Date;

/**
 *
 * @author LABS-ESPE
 */
public class Sheep extends FarmAnimal {
    private Date lastShearing;
    private int sge;

    // Constructor
    public Sheep(Date lastShearing, int sge, int id, String breed, Date bornOn, float weight) {
        super(id, breed, bornOn, weight);
        this.lastShearing = lastShearing;
        this.sge = sge;
    }

    // Getters y Setters
    public Date getLastShearing() {
        return lastShearing;
    }

    public void setLastShearing(Date lastShearing) {
        this.lastShearing = lastShearing;
    }

    public int getSge() {
        return sge;
    }

    public void setSge(int sge) {
        this.sge = sge;
    }

    // Método específico
    public boolean graze() {
        return true;
    }

    @Override
    public void feed(Food food) {
        System.out.println("Feeding sheep with " + food);
    }

    @Override
    public String toString() {
        return "Sheep{" + super.toString() + ", lastShearing=" + lastShearing + ", sge=" + sge + '}';
    }
}