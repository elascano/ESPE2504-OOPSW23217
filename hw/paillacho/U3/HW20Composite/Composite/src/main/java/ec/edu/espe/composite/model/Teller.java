package ec.edu.espe.composite.model;

/**
 *
 * @author Carlos Paillacho
 */
public class Teller extends Employee {

    /**
     * Default constructor sets the title.
     */
    public Teller() {
        title = "Teller";
    }

    /**
     * Constructs a Teller with a name.
     *
     * @param aName the teller's name
     */
    public Teller(String aName) {
        this();
        name = aName;
    }

    @Override
    public void stateName() {
        super.stateName();
    }
}
