package ec.edu.espe.farm.model;

/**
 *
 * @author LABS-ESPE
 */
public class Food {
    private String description;

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Food{" + "description=" + description + '}';
    }

    public Food(String description) {
        this.description = description;
    }

   
   
   
}
    
