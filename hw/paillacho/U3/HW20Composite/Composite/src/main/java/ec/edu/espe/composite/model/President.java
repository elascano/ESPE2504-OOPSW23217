package ec.edu.espe.composite.model;

/**
 *
 * @author Carlos Paillacho
 */
public class President extends Supervisor {
    private static final President president = new President();

    /**
     * Private constructor sets the title.
     */
    private President() {
        title = "President";
    }

    /**
     * Retrieves the single President instance and sets its name.
     *
     * @param aName the president's name
     * @return the singleton President instance
     */
    public static President getPresident(String aName) {
        president.name = aName;
        return president;
    }

    @Override
    public void stateName() {
        // Additional behavior for President if needed
        super.stateName();
    }
}
