/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espe.client.view;

import ec.edu.espe.client.model.GUIFactory;
import ec.edu.espe.client.model.Button;


/**
 *
 * @author jorge
 */
public class ClientApp {

    public static void main(String[] args) {
        GUIFactory aFactory = GUIFactory.getFactory();
        Button aButton = aFactory.createButton();
        aButton.caption="Play";
        aButton.paint();
    }
}
