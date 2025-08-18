package ec.edu.espe.compositepattern.model;

/**
 *
 * @author Julio Andrade
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
