package ec.edu.espe.farm.model;

import java.util.Date;

/**
 *
 * @author LABS-ESPE
 */
public class Sheep extends FarmAnimal{
    private Date lastSheering;
    private double woolWeightKg;

    public Sheep(Date lastSheering, double woolWeightKg, int id, String breed, Date bornOn) {
        super(id, breed, bornOn);
        this.lastSheering = lastSheering;
        this.woolWeightKg = woolWeightKg;
    }

    @Override
    public String toString() {
        return "Sheep{" + super.toString()+ "lastSheering=" + getLastSheering() + ", woolWeightKg=" + getWoolWeightKg() + '}';
    }

    
    
    @Override
    public void feed(Food food) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * @return the lastSheering
     */
    public Date getLastSheering() {
        return lastSheering;
    }

    /**
     * @param lastSheering the lastSheering to set
     */
    public void setLastSheering(Date lastSheering) {
        this.lastSheering = lastSheering;
    }

    /**
     * @return the woolWeightKg
     */
    public double getWoolWeightKg() {
        return woolWeightKg;
    }

    /**
     * @param woolWeightKg the woolWeightKg to set
     */
    public void setWoolWeightKg(double woolWeightKg) {
        this.woolWeightKg = woolWeightKg;
    }
    
    
}
