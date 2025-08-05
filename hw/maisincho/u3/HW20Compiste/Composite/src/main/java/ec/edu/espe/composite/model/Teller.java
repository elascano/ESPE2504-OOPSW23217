package ec.edu.espe.composite.model;

import ec.edu.espe.composite.controller.Employee;

/**
 *
 * @author Isaac Maisincho Crafters_Market DCCO ESPE
 */
public class Teller extends Employee {

    public Teller(String aName) {
        this();
        name = aName;
    }

    @Override
    public void stateName() {
        super.stateName();
    }

    public Teller() {
        title = "Teller";
    }

}
