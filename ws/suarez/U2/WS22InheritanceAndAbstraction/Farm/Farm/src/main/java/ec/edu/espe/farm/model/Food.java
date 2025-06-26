package ec.edu.espe.farm.model;

/**
 *
 * @author BERNARDO SUAREZ
 */
public class Food {
    private String description;

    @Override
    public String toString() {
        return "Food{" + "description = " + description + '}';
    }
    
    public Food(String description){
        this.description = description;
    }
    
}
