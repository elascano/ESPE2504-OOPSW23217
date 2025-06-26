package ec.edu.espe.farm.model;

/**
 *
 * @author Kevin Vaca
 */
public class Food {
    private String description;

    @Override
    public String toString() {
        return "Food{" + "description=" + description + '}';
    }

    public Food(String description) {
        this.description = description;
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
