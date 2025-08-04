package ec.edu.espe.model;

/**
 *
 * @author bernardo
 */

public abstract class Menu {
    protected String caption;

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public abstract void paint();
}
