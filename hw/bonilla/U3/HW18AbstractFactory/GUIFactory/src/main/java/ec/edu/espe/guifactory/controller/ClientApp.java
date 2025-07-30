
package ec.edu.espe.guifactory.controller;

/**
 *
 * @author Bonilla David SoftCrafters
 */

﻿

class ClientApp {
    public static void main(String[] args) {
        GUIFactory aFactory = GUIFactory.getFactory(); Button aButton = aFactory.createButton();
        aButton.caption = "Play";
        aButton.paint();
    }
}
