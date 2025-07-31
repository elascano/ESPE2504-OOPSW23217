package ec.edu.espe.composite.model;

import java.util.ArrayList;

/**
 *
 * @author Tammy Caizapanta SoftCrafters DCCO ESPE
 */
public abstract class Supervisor extends Employee {

    // Changed from Vector to ArrayList
    protected ArrayList<Employee> directReports = new ArrayList<>();

    public void stateName() {
        super.stateName(); // print name of this employee first
        if (directReports.size() > 0) // be sure there are elements
        {
            // Changed to enhanced for-loop for ArrayList
            for (Employee emp : directReports) {
                emp.stateName();
            }
        }
    }

    public void add(Employee anEmployee) {
        this.directReports.add(anEmployee); // Changed from addElement to add
    }
}