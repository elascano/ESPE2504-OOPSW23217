package ec.edu.espe.composite.model;

/**
 *
 * @author Carlos Paillacho
 */
public class Manager extends Supervisor {

    /**
     * Default constructor sets the title.
     */
    public Manager() {
        title = "Manager";
    }

    /**
     * Constructs a Manager with a name.
     *
     * @param aName the manager's name
     */
    public Manager(String aName) {
        this();
        name = aName;
    }

    /**
     * Custom processing for manager naming could go here.
     */
    @Override
    public void stateName() {
        // Additional behavior for Manager if needed
        super.stateName();
    }
}