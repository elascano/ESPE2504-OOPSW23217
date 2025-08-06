package ec.edu.espe.view;
import ec.edu.espe.model.*;

/**
 *
 * @author bernardo
 */

public class ClientApp {
    
    public static void main(String[] args) {
        GUIFactory factory = GUIFactory.getFactory();

        Button button = factory.createButton();
        button.setCaption("Save");
        button.paint();

        Menu menu = factory.createMenu();
        menu.setCaption("Main Menu");
        menu.paint();
    }
    
}
