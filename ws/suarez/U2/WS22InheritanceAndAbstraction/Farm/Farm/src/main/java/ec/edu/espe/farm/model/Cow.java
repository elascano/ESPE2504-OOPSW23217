package ec.edu.espe.farm.model;
import java.util.Date;

/**
 *
 * @author BERNARDO SUAREZ
 */
public class Cow extends FarmAnimal {
    private boolean isProducingMilk;

    public Cow(int id, String breed, Date bornOn, boolean isProducingMilk) {
        super(id, breed, bornOn);
        this.isProducingMilk = isProducingMilk;
    }
    
    @Override
    public String toString() {
        return "Cow{"+ super.toString() + ", isProducingMilk = " + isProducingMilk + '}';
    }
    
    @Override
    public void feed(Food food) {
        System.out.println("feeding cows with " + food);
    }
}
