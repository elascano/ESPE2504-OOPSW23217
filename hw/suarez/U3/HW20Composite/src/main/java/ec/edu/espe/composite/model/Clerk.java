package ec.edu.espe.composite.model;

/**
 * @author bernardo
 */

public class Clerk extends Employee { //add public

    public Clerk(String aName) {
        this();
        name = aName;
    }

    public void stateName() {
        super.stateName();
    }

    public Clerk() {
        title = "Clerk";
    }
}
