package ec.espe.edu.question33.model;

/**
 *
 * @author Bonilla Caiza SoftCrafters
 */
public class Cellphone {
    
    //Attributes
    private int id;
    private int width;
    private int height;
    private String type;
    
    //Constructor

    public Cellphone(int id, int width, int height, String type) {
        this.id = id;
        this.width = width;
        this.height = height;
        this.type = type;
    }

    
    
    //Methods
    
    
    
    //Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    
}
