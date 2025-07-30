package ec.edu.espe.guifactory.model;

/**
 *
 * @author Jahir Sivinta DDCO
 */
public abstract class Menu {
    public String caption;
    public abstract void paint();

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }
    
}
