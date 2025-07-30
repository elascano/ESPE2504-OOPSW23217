package com.mycompany.guifactory;

/**
 *
 * @author Jahir Sivinta Jsnow DCCO ESPE
 */
public abstract class UIComponent {
    protected String caption;

    public UIComponent(String caption) {
        this.caption = caption;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public abstract void paint();
}
