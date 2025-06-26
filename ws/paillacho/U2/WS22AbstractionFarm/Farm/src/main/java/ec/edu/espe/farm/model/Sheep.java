package ec.edu.espe.farm.model;

import java.util.Date;

/**
 * Clase que representa una oveja en la granja.
 * Autor: Carlos Paillacho
 */
public class Sheep extends FarmAnimal {

    private Date lastSheering;

    public Sheep(int id, String breed, Date bornOn, Date lastSheering) {
        super(id, breed, bornOn);
        this.lastSheering = lastSheering;
    }

    public Date getLastSheering() {
        return lastSheering;
    }

    public void setLastSheering(Date lastSheering) {
        this.lastSheering = lastSheering;
    }

    @Override
    public String toString() {
        return super.toString() + ", Sheep{" + "lastSheering=" + lastSheering + '}';
    }
}
