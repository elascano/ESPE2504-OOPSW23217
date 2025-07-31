package ec.edu.espe.composite.model;

import java.util.Vector;

/**
 *
 * @author Mateo Unda
 */
public abstract class Supervisor extends Employee {

    protected Vector directReports = new Vector();

    public void stateName() {
        super.stateName(); // print name of this employee first
        if (directReports.size() > 0) // be sure there are elements
        {
            for (int i = 0; i < directReports.size(); ++i) {
                ((Employee) directReports.elementAt(i)).stateName();
            }
        }
    }

    public void add(Employee anEmployee) {
        this.directReports.addElement(anEmployee);
    }
}
