package ec.edu.espe.q71to100.model;

/**
 *
 * @author Bonilla David SoftCrafters
 */
public class Product {

    private int id;
    private String name;
    private float value;
    private int quantity;

    public Product(int id, String name, float value, int quantity) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.quantity = quantity;
    }

    public float calculate(float value, int quantity) {
        return value * quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
