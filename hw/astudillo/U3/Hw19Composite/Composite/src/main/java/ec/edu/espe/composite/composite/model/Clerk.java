package ec.edu.espe.composite.composite.model;

public class Clerk extends Employee {
    public Clerk(String aName) {
        this();
        name = aName;
    }
    
    public void stateName() {
        super.stateName(title, name);
    }
    
    public Clerk() {
        title = "Clerk";
    }
}
