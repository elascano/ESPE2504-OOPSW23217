package ec.edu.espe.composite.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carlos Paillacho
 */
public abstract class Supervisor extends Employee {
    protected List<Employee> directReports = new ArrayList<>();

    /**
     * Prints this supervisor's name and then each direct report's name.
     */
    @Override
    public void stateName() {
        super.stateName();
        if (!directReports.isEmpty()) {
            for (Employee e : directReports) {
                e.stateName();
            }
        }
    }

    /**
     * Adds a direct report to this supervisor.
     *
     * @param anEmployee the employee to add
     */
    public void add(Employee anEmployee) {
        directReports.add(anEmployee);
    }
}
