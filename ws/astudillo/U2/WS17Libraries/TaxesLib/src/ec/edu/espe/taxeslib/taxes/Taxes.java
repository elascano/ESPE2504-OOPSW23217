/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.taxeslib.taxes;

/**
 * Thius class is used to compute some taces in Ecuador such as:
 * -Iva
 * -Impuesto
 * -Ice
 * @author Gerald Astudillo
 * @version 1.0
 */
public class Taxes {
    
    /**
     * It computes the sales taxes for Products in Ecuador
     * @param base Base price of the product
     * @param taxPercentage tax percentage that is is regulated by the government
     * @return the value of sales taxes a product produces
     */
    public static float computeIva(float base, float taxPercentage) {
        float ivaValue;
        ivaValue = base * taxPercentage / 100;
        return ivaValue;
    }

    public static float computeTotal(float base, float taxPercentage) {
        float total;
        total = base + computeIva(base, taxPercentage);
        return total;
    }
}
