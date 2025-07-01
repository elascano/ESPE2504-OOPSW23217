package ec.edu.espe.farm.model;

import java.util.Date;
import java.util.concurrent.TimeUnit;

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

    // Método para obtener la edad en meses aproximada
    public int getAgeInMonths() {
        Date today = new Date();
        long diffInMillis = today.getTime() - bornOn.getTime();

        // Convertir diferencia a meses aproximados
        long millisInMonth = (long) (1000L * 60 * 60 * 24 * 30.44); // promedio de días por mes
        int ageInMonths = (int) (diffInMillis / millisInMonth);
        return ageInM
