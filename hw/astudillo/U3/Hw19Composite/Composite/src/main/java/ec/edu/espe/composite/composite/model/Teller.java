package ec.edu.espe.composite.composite.model;

public class Teller extends Employee {
    public Teller(String aName) {
        this();
        name = aName;
    }
    
    public void stateName() {
        super.stateName(title, name);
    }
    
    public Teller() {
        title = "Teller";
    }
}
