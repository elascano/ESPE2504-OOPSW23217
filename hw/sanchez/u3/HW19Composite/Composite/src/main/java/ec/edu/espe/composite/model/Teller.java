package ec.edu.espe.composite.model;

/**
 *
 * @author Jahir Sivinta DCCO
 */
public class Teller extends Employee {

    public Teller(String aName) {
        this();
        name = aName;
    }

    public void stateName() {
        super.stateName();
    }

    public Teller() {
        title = "Teller";
    }

}
