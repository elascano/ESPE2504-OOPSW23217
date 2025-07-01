
package ec.edu.espe.farm.model;

import java.util.Date;

/**
 *
 * @author LABS-ESPE
 */
public class Sheep extends FarmAnimal{

    private Date lastSheerig;
    private String woolColor;

    public Sheep(Date lastSheerig, String woolColor, int id, String breed, Date bornOn) {
        super(id, breed, bornOn);
        this.lastSheerig = lastSheerig;
        this.woolColor = woolColor;
    }

    @Override
    public String toString() {
        return "Sheep{" + "lastSheerig=" + lastSheerig + ", woolColor=" + woolColor + '}';
    }

    
    /**
     * @return the lastSheerig
     */
    public Date getLastSheerig() {
        return lastSheerig;
    }
    
    public void isSheering(){
        System.out.println("The sheep is sheering...");
        
    }
    
    /**
     * @param lastSheerig the lastSheerig to set
     */
    public void setLastSheerig(Date lastSheerig) {
        this.lastSheerig = lastSheerig;
    }

    /**
     * @return the woolColor
     */
    public String getWoolColor() {
        return woolColor;
    }

    /**
     * @param woolColor the woolColor to set
     */
    public void setWoolColor(String woolColor) {
        this.woolColor = woolColor;
    }

    @Override
    public void feed(Food food) {
        System.out.println("Feeding sheep with " + food);
    }
 
    
    
    
}
