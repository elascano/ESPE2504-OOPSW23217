package ec.edu.espe.composite.model;

/**
 *
 * @author Carlos Paillacho
 */
public abstract class Employee {
    protected String name = "not assigned yet";
    protected String title = "not assigned yet";

    /**
     * Prints the title and name of the employee.
     */
    public void stateName() {
        System.out.println(title + " " + name);
    }
}