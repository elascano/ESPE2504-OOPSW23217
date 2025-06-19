package ec.edu.espe.farm.model;

import java.util.Date;

/**
 *
 * @author LABS-ESPE
 */
public class Pig extends FarmAnimal{
    private boolean hasTask;

    public Pig(boolean hasTask, int id, String breed, Date bornOn) {
        super(id, breed, bornOn);
        this.hasTask = hasTask;
    }

    @Override
    public String toString() {
        return "Pig{" + "hasTask=" + hasTask + '}';
    }

    
    @Override
    public void feed(Food food) {
        System.out.println("feeding pigs with " + food);
    }

    /**
     * @return the hasTask
     */
    public boolean isHasTask() {
        return hasTask;
    }

    /**
     * @param hasTask the hasTask to set
     */
    public void setHasTask(boolean hasTask) {
        this.hasTask = hasTask;
    }
    
    
    
    
}
