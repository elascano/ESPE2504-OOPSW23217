/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.taxes.controller;

/**
 *
 * @author LABS-ESPE
 */
public class Tax {
    public float computeTax(float basePrice, float percentage,boolean charged){
        float ivaValue=0.0F;
        if(!charged){
            ivaValue = 0.0F;
        }else{
            ivaValue = basePrice * percentage /100;
           
        }
         return ivaValue;
    }
    public float computeIce(float basePrice){
        return 0.0F;
    }
}
