/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.enterprise.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jorge
 */
public abstract class Supervisor extends Employee{
    protected List<Employee> directReports = new ArrayList<>();

    @Override
    public void stateName(){
        super.stateName();
        if(directReports.size()>0)
            for(int i=0;i<directReports.size();++i)
                (directReports.get(i)).stateName();
    }
    
    public void add(Employee anEmployee){
        directReports.add(anEmployee);
    }
        
    
}
