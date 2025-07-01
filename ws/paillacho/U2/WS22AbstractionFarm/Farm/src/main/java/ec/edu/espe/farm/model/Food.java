package ec.edu.espe.farm.model;

/**
 *
 * @author Carlos Paillacho
 */
public class Food {
    
    private String description;

    public Food(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Food{" + "description='" + description + '\'' + '}';
    }
}
