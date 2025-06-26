package ec.edu.espe.farm.model;

import java.util.Date;

/**
 *
 * @author Carlos Paillacho
 */
public class Chicken extends FarmAnimal {

    private boolean isMolting;

    public Chicken(int id, String breed, Date bornOn, boolean isMolting) {
        super(id, breed, bornOn);
        this.isMolting = isMolting;
    }

    public boolean isMolting() {
        return isMolting;
    }

    public void setMolting(boolean isMolting) {
        this.isMolting = isMolting;
    }

    @Override
    public String toString() {
        return super.toString() + ", Chicken{" + "isMolting=" + isMolting + '}';
    }
}
