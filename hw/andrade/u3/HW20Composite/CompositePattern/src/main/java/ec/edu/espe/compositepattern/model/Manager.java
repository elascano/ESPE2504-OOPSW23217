package ec.edu.espe.compositepattern.model;

/**
 *
 * @author Julio Andrade
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
