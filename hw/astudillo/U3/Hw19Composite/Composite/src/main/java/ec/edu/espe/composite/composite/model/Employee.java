package ec.edu.espe.composite.composite.model;

public abstract class Employee {
    String name = "not assigned yet";
    String title = "not assigned yet";

    public void stateName(String title, String name) {
        System.out.println(title + " " + name);
    }
}
