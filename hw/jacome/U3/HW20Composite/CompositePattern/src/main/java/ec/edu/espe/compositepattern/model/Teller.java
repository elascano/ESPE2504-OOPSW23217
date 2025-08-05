package ec.edu.espe.compositepattern.model;

/**
 *
 * @author Micaela Jácome
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
