/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.ustax.model;

/**
 *
 * @author jorge
 */
public class USTax {
    private static USTax instance;
    private USTax(USTax instance){
        this.instance = instance;
        
    }
    public static USTax getInstance(){
        if(instance==null)
            instance = new USTax();
        return instance;
    }
    
    public float CalculatesalesTotal(){
        return 0.0F;
    }
    
}
