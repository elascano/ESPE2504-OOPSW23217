/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.enterprise.model;

/**
 *
 * @author jorge
 */
public class Manager extends Supervisor{
    
    public Manager(String aName){
        this();
        name=aName;
    }
    
    public Manager(){
        super();
        title="Manager";
        
    }
    
    @Override
    public void stateName(){
        super.stateName();
    }
    
}
