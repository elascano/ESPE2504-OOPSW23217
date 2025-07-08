package ec.edu.espe.farm.model;

import java.util.Date;

/**
 * Clase que representa una vaca en la granja.
 * Autor: Carlos Paillacho
 */
public class Cow extends FarmAnimal {

    private float milkProduction; // en litros por día

    public Cow(int id, String breed, Date bornOn, float milkProduction) {
        super(id, breed, bornOn);
        this.milkProduction = milkProduction;
    }

    public float getMilkProduction() {
        return milkProduction;
    }

    public void setMilkProduction(float milkProduction) {
        this.milkProduction = milkProduction;
    }

    @Override
    public String toString() {
        return super.toString() + ", Cow{" + "milkProduction=" + milkProduction + "L/day}";
    }
}
