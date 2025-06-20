package ec.edu.espe.farm.model;

import java.util.Date;

/**
 *
 * @author Carlos Paillacho
 */
public abstract class FarmAnimal {

    private int id;
    private String breed;
    private Date bornOn;

    public FarmAnimal(int id, String breed, Date bornOn) {
        this.id = id;
        this.breed = breed;
        this.bornOn = bornOn;
    }

    public int getId() {
        return id;
    }

    public String getBreed() {
        return breed;
    }

    public Date getBornOn() {
        return bornOn;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setBornOn(Date bornOn) {
        this.bornOn = bornOn;
    }
    
    public void feed(Food food) {
    System.out.println("Feeding the " + this.getClass().getSimpleName() + " with " + food.getDescription());
    }

    @Override
    public String toString() {
        return "FarmAnimal{" + "id=" + id + ", breed=" + breed + ", bornOn=" + bornOn + '}';
    }

    // Método que puede ser sobrescrito si deseas calcular edad, opcional
    public int getAgeInMonths() {
        // Implementaci

    
   