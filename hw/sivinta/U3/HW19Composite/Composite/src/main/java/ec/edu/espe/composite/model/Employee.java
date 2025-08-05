package ec.edu.espe.composite.model;

/**
 *
 * @author Jahir Sivinta DCCO
 */
public abstract class Employee {

    String name = "not assigned yet";
    String title = "not assigned yet";

    public void stateName() {
        System.out.println(title + " " + name);
    }
}
