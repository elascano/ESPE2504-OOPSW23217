package ec.edu.espe.farm.model;
import java.util.Date;
/**
 *
 * @author bernardo suarez
 */
public class Sheep extends FarmAnimal {
    
    private boolean isReadyForShearing;
    private String lastShearing;

    public Sheep(int id, String breed, Date bornOn, boolean isReadyForShearing, String lastShearing) {
        super(id, breed, bornOn);
        this.isReadyForShearing = isReadyForShearing;
        this.lastShearing = lastShearing;
    }

    @Override
    public String toString() {
        return "Sheep{" + super.toString() + ", isReadyForShearing = " + isReadyForShearing + ", lastShearing = " + lastShearing + '}';
    }
    
    @Override
    public void feed(Food food) {
        System.out.println("feeding sheeps with " + food);
    }
}
