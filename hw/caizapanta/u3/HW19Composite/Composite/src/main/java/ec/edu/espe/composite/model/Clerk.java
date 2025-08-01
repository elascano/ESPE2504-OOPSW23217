package ec.edu.espe.composite.model;

/**
 *
 * @author Tammy Caizapanta SoftCrafters DCCO ESPE
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
