package ec.edu.espe.model;

/**
 *
 * @author bernardo
 */

public class WinFactory extends GUIFactory {
    
    @Override
    public Button createButton() {
        return new WinButton();
    }

    @Override
    public Menu createMenu() {
        return new WinMenu();
    }
    
}