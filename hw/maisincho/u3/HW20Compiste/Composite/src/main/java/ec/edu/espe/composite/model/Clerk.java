package ec.edu.espe.composite.model;

import ec.edu.espe.composite.controller.Employee;

/**
 *
 * @author Isaac Maisincho Crafters_Market DCCO ESPE
 */
public class Clerk extends Employee {

    public Clerk(String aName) {
        this();
        name = aName;
    }
    @Override
    public void stateName(){
        super.stateName();
    }
    public Clerk(){
        title="Clerk";
    }
}
