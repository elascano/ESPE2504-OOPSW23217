
package ec.edu.espe.guifactory.controller;

import ec.edu.espe.guifactory.model.Button;

/**
 *
 * @author Bonilla David SoftCrafters
 */
public class ClientApp {
    public static void main(String[] args) {
        GUIFactory aFactory = GUIFactory.getFactory(); Button aButton = aFactory.createButton();
        aButton.caption = "Play";
        aButton.paint();
    }
}
