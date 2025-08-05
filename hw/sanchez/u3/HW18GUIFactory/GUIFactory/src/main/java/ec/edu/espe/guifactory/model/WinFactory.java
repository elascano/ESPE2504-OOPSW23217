package ec.edu.espe.guifactory.model;

import ec.edu.espe.guifactory.controller.GUIFactory;
import ec.edu.espe.guifactory.view.WinButton;
import ec.edu.espe.guifactory.view.WinMenu;

/**
 *
 * @author Jahir Sivinta DDCO
 */
public class WinFactory extends GUIFactory { 
    public Button createButton() { 
        return(new WinButton());
    }
    public Menu createMenu() {
        return(new WinMenu());
    }
}
