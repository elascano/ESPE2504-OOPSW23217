package ec.edu.espe.composite.controller;

import java.util.ArrayList;

/**
 *
 * @author Isaac Maisincho Crafters_Market DCCO ESPE
 */
public abstract class Employee {

    public String name;
    public String title;
    private ArrayList<Employee> subordinates = new ArrayList<>();

    public void add(Employee e) {
        subordinates.add(e);
    }

    public void remove(Employee e) {
        subordinates.remove(e);

    }

    public void stateName() {
        System.out.println(title + " " + name);
        for (Employee e : subordinates) {
            e.stateName();
        }
    }
}
