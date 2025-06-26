
package ec.edu.espe.farm.model;

/**
 *
 * @author Sanchez Julio
 */
public class Food {
    private String description;

    
    public Food(String description) {
        this.description = description;
    }

    
    @Override
    public String toString() {
        return "Food{" + "description=" + description + '}';
    }
    
    
    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
}
