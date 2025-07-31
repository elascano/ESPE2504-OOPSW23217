package ec.edu.espe.composite.model;

/**
 *
 * @author Carlos Paillacho
 */
public class Clerk extends Employee {

    /**
     * Default constructor sets the title.
     */
    public Clerk() {
        title = "Clerk";
    }

    /**
     * Constructs a Clerk with a name.
     *
     * @param aName the clerk's name
     */
    public Clerk(String aName) {
        this();
        name = aName;
    }

    @Override
    public void stateName() {
        super.stateName();
    }
}
