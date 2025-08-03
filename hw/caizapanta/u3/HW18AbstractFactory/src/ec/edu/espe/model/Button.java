package ec.edu.espe.model;

/**
 * 
 * @author Tammy Caizapanta
 */

public abstract class Button {
    protected String caption;

    public void setCaption(String caption) {
        this.caption = caption;
    }
    public abstract void paint();
}
