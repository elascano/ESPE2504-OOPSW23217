package ec.edu.espe.compositepattern.model;

/**
 *
 * @author Daniel Palacios
 */
public class Teller extends Employee {

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
