package ec.edu.espe.farm.model;
import java.util.Date;

/**
 *
 * @author BERNARDO SUAREZ
 */
public class Chicken extends FarmAnimal {
    
    private boolean isMolting;
    private int numberOfEggs;
    
    public Chicken(int id, String breed, Date bornOnDate, boolean isMolting, int numberOfEggs) {
        super(id, breed, bornOnDate);
        this.isMolting = isMolting;
        this.numberOfEggs = numberOfEggs;
    }
    
    @Override
    public void feed(Food food) {
        System.out.println("feeding chickens with " + food);
    }

    @Override
    public String toString() {
        return "Chicken{"+ super.toString() + ", isMolting = " + isMolting + ", numberOfEggs = " + numberOfEggs + '}';
    }
}
