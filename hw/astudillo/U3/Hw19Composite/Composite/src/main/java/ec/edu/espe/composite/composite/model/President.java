package ec.edu.espe.composite.composite.model;

public class President extends Supervisor {
    private static President president = new President();
    
    private President(String aName) {
        this();
        name = aName;
    }
    
    private President() {
        super();
        title = "President";
    }
    
    public void stateName() {
        super.stateName(title, name);
    }
    
    public static President getPresident(String aName) {
        president.name = aName;
        return president;
    }
}
