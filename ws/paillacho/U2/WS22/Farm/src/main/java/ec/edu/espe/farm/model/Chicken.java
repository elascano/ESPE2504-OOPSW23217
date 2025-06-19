package ec.edu.espe.farm.model;

/**
 *
 * @author Carlos Paillacho
 */
public class Chicken extends FarmAnimal {

    public Chicken(int id, String breed, Object bornOn) {
        super(id, breed, bornOn);
    }

    /**
     * @return the isMolting
     */
    public boolean isIsMolting() {
        return isMolting;
    }

    /**
     * @param isMolting the isMolting to set
     */
    public void setIsMolting(boolean isMolting) {
        this.isMolting = isMolting;
    }
    
    private boolean isMolting;
}
