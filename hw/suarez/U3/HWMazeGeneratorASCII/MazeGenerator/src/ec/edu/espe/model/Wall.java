package ec.edu.espe.model;

public class Wall {
    protected boolean open;

    public Wall() {
        this.open = false;
    }

    public boolean isOpen() {
        return open;
    }

    public void open() {
        this.open = true;
    }
}
