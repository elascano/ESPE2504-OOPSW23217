package ec.edu.espe.composite.composite.model;

import java.util.Vector;

public abstract class Supervisor extends Employee {
    protected Vector directReports = new Vector();
    
    @Override
    public void stateName(String title, String name) {
        super.stateName(title, name);
        if (!directReports.isEmpty()) {
            for (int i = 0; i < directReports.size(); ++i) {
                Employee emp = (Employee) directReports.elementAt(i);
                emp.stateName(emp.title, emp.name);
            }
        }
    }
    
    public void add(Employee anEmployee) {
        this.directReports.addElement(anEmployee);
    }
}
