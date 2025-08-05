package ec.edu.espe.composite.model;

/**
 * @author bernardo
 */
public class President extends Supervisor { //add public

    private static President president = new President();

    private President(String aName) {
        this();
        name = aName;
    }

    private President() {
        super();
        title = "President";
    }

    public void stateName() { // Do processing special to presidential naming
        super.stateName();
    }

    public static President getPresident(String aName) {
        president.name = aName;
        return President.president;
    }
}
