package ec.edu.espe.compositepattern.model;

<<<<<<< HEAD
import java.util.Vector;
=======
import java.util.ArrayList;
import java.util.List;
>>>>>>> 1e4c7996c2a22e02abbfff4a34b99d02ef14e579

/**
 *
 * @author Micaela Jácome
 */
<<<<<<< HEAD
public class Supervisor extends Employee{

    protected Vector directReports = new Vector();

    public void stateName() {
        super.stateName(); // print name of this employee first
        if (directReports.size() > 0) // be sure there are elements
        {
            for (int i = 0; i < directReports.size(); ++i) {
                ((Employee) directReports.elementAt(i)).stateName();
=======
public class Supervisor extends Employee {

    protected List<Employee> directReports = new ArrayList<>();

    public void stateName() {
        super.stateName(); // print name of this employee first
        if (!directReports.isEmpty()) // be sure there are elements
        {
            for (Employee employee : directReports) {
                employee.stateName();
>>>>>>> 1e4c7996c2a22e02abbfff4a34b99d02ef14e579
            }
        }
    }

    public void add(Employee anEmployee) {
<<<<<<< HEAD
        this.directReports.addElement(anEmployee);
    }
}
=======
        this.directReports.add(anEmployee);
    }
}
>>>>>>> 1e4c7996c2a22e02abbfff4a34b99d02ef14e579
