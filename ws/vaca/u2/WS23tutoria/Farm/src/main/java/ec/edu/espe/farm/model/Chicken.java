package ec.edu.espe.farm.model;
import java.util.Date;


/**
 *
 * @author Kevin Vaca
 */
public class Chicken extends FarmAnimal{
    
    private boolean isMolting;
    private int numberOfEggs;

    public Chicken(int id, String breed, Date bornOn, boolean molting) {
        super(id, breed, bornOn);
        this.isMolting = isMolting;
    }

    public Chicken(boolean isMolting, int id, String breed, Date bornOn) {
        super(id, breed, bornOn);
        this.isMolting = isMolting;
    }

    @Override
    public String toString() {
        return "Chicken{" + super.toString() + ", isMolting=" + isMolting + '}';
    }

    @Override
    public void feed(Food food) {
        System.out.println("Feeding chickens with: " + food);
    }

    public int addEgg() {
        numberOfEggs++;
        return numberOfEggs;       
    }
}