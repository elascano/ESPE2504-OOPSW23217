package ec.edu.espe.composite.model;

import ec.edu.espe.composite.controller.Employee;
import java.util.Vector;

/**
 *
 * @author Isaac Maisincho Crafters_Market DCCO ESPE
 */
public abstract class Supervisor extends Employee {

    protected Vector directReports = new Vector();

    @Override
    public void stateName() {
        super.stateName();
        if (directReports.size() > 0);
        for (int i = 0; i < directReports.size(); ++i) {
            ((Employee) directReports.elementAt(i)).stateName();
        }
    }
    @Override
    public void add(Employee anEmployee){
        this.directReports.addElement(anEmployee);
    }
}
