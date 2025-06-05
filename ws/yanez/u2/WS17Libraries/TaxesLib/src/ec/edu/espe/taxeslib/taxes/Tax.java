/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.taxeslib.taxes;

/**
 * This class is used to compute some taxes in Ecuador such as:
 * -IVA
 * -Impuesto a la renta
 * -ICE
 * @author José Yánez
 * @version 1.0
 */
public class Tax {
    
    /**
     * Computes the sales taxes for Products in Ecuador
     * @param base Base price of the product
     * @param taxPercentage tax percentage that is regulated by the goverment
     * @return the value of the sale taxes that a product produces
     */
    public static float computeIva(float base, float taxPercentage){
        float ivaValue;
        
        //this is where you put your very complex algorithm
        ivaValue = base * taxPercentage/100;
        
        return ivaValue;
    }
    
    public static float computeTotal(float base, float taxPercentage){
        float total;
        
        total = base + computeIva(base, taxPercentage);
        return total;
    }
    
    
}
