package ec.edu.espe.model;

/**
 * 
 * @author Tammy Caizapanta
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