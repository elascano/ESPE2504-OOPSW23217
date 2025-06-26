
package espe.edu.ec.view.model;

import java.util.Date;

/**
 *
 * @author Isaac Maisincho 
 */
public class Sheep extends FarmAnimal {

    private float woolAmount; 

    public Sheep(float woolAmount, int id, String breed, Date bornOn) {
        super(id, breed, bornOn);
        this.woolAmount = woolAmount;
    }

    @Override
    public void feed(Food food) {
        System.out.println("Feeding sheep with " + food);
    }

    @Override
    public String toString() {
        return "Sheep{" + super.toString() + "woolAmount=" + woolAmount + "kg}";
    }

    public float getWoolAmount() {
        return woolAmount;
    }

    public void setWoolAmount(float woolAmount) {
        this.woolAmount = woolAmount;
    }
}

