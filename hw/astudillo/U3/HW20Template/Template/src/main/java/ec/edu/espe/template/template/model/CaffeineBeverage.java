/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.template.template.model;

/**
 *
 * @author PC
 */
public abstract class CaffeineBeverage {
    void prepareRecipe(){
        boilWater();
        brew();
        pourInCup();
        if(wantsCondimate()){
            addCondimate();
        }
    }
    
    void boilWater(){
        System.out.println("Boiling water");
    }
    
    abstract void brew();
    
    void pourInCup(){
        System.out.println("Pouring in a cup");
    }
    
    abstract void addCondimate();
    
    boolean wantsCondimate(){
        return true;
    }
}
