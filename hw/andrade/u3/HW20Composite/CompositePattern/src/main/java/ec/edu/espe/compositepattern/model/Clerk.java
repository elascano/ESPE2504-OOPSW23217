package ec.edu.espe.compositepattern.model;

/**
 *
 * @author Micaela Jácome
 */
public class Clerk extends Employee{

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
