package ec.edu.espe.hw16mazegenerator.model;

/**
 *
 * @author Mateo Unda
 */
public class Wall {

    private boolean isOpen;

    public Wall() {
        this.isOpen = false;
    }

    public void open() {
        isOpen = true;
    }

    public boolean isOpen() {
        return isOpen;
    }
}
