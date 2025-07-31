/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.enterprise.model;

/**
 *
 * @author jorge
 */
public class Clerk extends Employee{
    public Clerk(String aName){
        this();
        name=aName;
        
    }
    
    @Override
    public void stateName(){
        super.stateName();
    }
    
    public Clerk(){
        title="Clerk";
    }
    
    
}
