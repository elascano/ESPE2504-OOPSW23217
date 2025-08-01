package ec.edu.espe.composite.model;

/**
 *
 * @author Isaac Maisincho Crafters_Market DCCO ESPE
 */
public class Manager extends Supervisor {

    public Manager(String aName) {
        this();
        name = aName;
    }

    public Manager() {
        super();
        title = "Manager";
    }

    @Override
    public void stateName() {
        super.stateName();
    }

}
