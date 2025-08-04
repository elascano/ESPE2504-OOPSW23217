package ec.edu.espe.composite.model;

/**
 * @author bernardo
 */

public class Teller extends Employee { //add public

    public Teller(String aName) {
        this();
        name = aName;
    }

    public void stateName() {
        super.stateName();
    }

    public Teller() {
        title = "Teller";
    }

}
