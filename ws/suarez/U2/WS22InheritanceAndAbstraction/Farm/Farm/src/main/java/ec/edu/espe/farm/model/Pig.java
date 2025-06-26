package ec.edu.espe.farm.model;
import java.util.Date;
/**
 *
 * @author bernardo suarez
 */
public class Pig extends FarmAnimal {

    public Pig(int id, String breed, Date bornOn) {
        super(id, breed, bornOn);
    }

    @Override
    public String toString() {
        return "Pig{" + super.toString() + '}';
    }
    
    @Override
    public void feed(Food food) {
        System.out.println("feeding pigs with " + food);
    }   
}
