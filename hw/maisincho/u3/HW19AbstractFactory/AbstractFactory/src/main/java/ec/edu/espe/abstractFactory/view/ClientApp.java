package ec.edu.espe.abstractFactory.view;

import ec.edu.espe.abstractFactory.controller.GUIFactory;
import ec.edu.espe.abstractFactory.model.Button;

/**
 *
 * @author Isaac Maisincho Crafters_Market DCCO ESPE
 */
public class ClientApp {

    public static void main(String[] args) {
        GUIFactory factory = GUIFactory.getFactory();
        Button button = factory.createButton();
        button.caption = "Play";
        button.paint();
        button.caption = "Exit";
        button.paint();
    }
}
