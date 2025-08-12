package ec.edu.espe.composite.model;

/**
 *
 * @author Quiroz Maria
 */
public class Clerk extends Employee {

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
