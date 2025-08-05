package ec.edu.espe.compositepattern.model;

/**
 *
 * @author Daniel Palacios
 */
public abstract class Employee {
    protected String name = "not assigned yet";
    protected String title = "not assigned yet";

    public void stateName() {
        System.out.println(title + " " + name);
    }
}
