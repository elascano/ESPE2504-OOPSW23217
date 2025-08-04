package ec.edu.espe.compositepattern.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel Palacios
 */
public class Supervisor extends Employee {

    protected List<Employee> directReports = new ArrayList<>();

    public void stateName() {
        super.stateName(); // print name of this employee first
        if (!directReports.isEmpty()) // be sure there are elements
        {
            for (Employee employee : directReports) {
                employee.stateName();
            }
        }
    }

    public void add(Employee anEmployee) {
        this.directReports.add(anEmployee);
    }
}
