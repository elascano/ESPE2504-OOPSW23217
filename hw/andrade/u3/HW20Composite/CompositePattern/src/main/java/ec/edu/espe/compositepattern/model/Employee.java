package ec.edu.espe.compositepattern.model;

/**
 *
 * @author Julio Andrade
 */
public abstract class Employee {
    protected String name = "not assigned yet";
    protected String title = "not assigned yet";

    public void stateName() {
        System.out.println(title + " " + name);
    }
}
