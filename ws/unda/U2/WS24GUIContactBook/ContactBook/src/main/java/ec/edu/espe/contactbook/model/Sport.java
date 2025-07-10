package ec.edu.espe.contactbook.model;

/**
 *
 * @author LABS-ESPE
 */
public class Sport {
    private int id;
    private int description;

    public Sport(int id, int description) {
        this.id = id;
        this.description = description;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the description
     */
    public int getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(int description) {
        this.description = description;
    }
    
}
