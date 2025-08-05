/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.singletonpattern.model;

/**
 *
 * @author Micaela Jácome
 */
public class USTax {

    private static USTax instance;
    private float taxPercentage;

    public USTax(float taxPercentage) {
        this.taxPercentage = taxPercentage;
    }

    public static USTax getInstance() {
        if (instance == null) {
            instance = new USTax(0.2F);
        }
        return instance;

    }

    public static void setInstance(USTax newInstance) {
        if (newInstance != null) {
            instance = newInstance;
        } else {
            System.out.println("Cannot set null instance ");
        }
    }

    public float getTaxPercentage() {
        return taxPercentage;
    }

    public void setTaxPercentage(float taxPercentage) {
        this.taxPercentage = taxPercentage;
    }
}
