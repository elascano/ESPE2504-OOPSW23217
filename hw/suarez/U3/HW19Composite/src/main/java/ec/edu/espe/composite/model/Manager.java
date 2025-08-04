package ec.edu.espe.composite.model;

/**
 * @author bernardo
 */

public class Manager extends Supervisor { //add public

    public Manager(String aName) {
        this();
        name = aName;

    }

    public Manager() {
        super();
        title = "Manager";
    }

    public void stateName() {
        //do processing special to manager naming
        super.stateName();
    }
}
