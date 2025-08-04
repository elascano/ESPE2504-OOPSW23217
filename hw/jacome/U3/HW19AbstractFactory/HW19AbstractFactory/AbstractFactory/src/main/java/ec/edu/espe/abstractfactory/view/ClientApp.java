<<<<<<< HEAD

package ec.edu.espe.abstractfactory.view;

import ec.edu.espe.abstractfactory.controller.GUIFactory;
import ec.edu.espe.abstractfactory.model.Button;
=======
package ec.edu.espe.abstractfactory.view;

import ec.edu.espe.abstractfactory.controller.GUIFactory;
import ec.edu.espe.abstractfactory.controller.LinuxFactory;
import ec.edu.espe.abstractfactory.controller.WinFactory;
import ec.edu.espe.abstractfactory.model.Button;
import ec.edu.espe.abstractfactory.model.Menu;
>>>>>>> 1e4c7996c2a22e02abbfff4a34b99d02ef14e579

/**
 *
 * @author Micaela Jacome DESKTOP-46VMNHU ESPE
 */
public class ClientApp {

<<<<<<< HEAD
    public static void main(String[] args){
        GUIFactory aFactory = GUIFactory.getFactory();
        Button aButton = aFactory.createButton();
        aButton.caption="Play";
        aButton.paint();
    }
=======
    public static void main(String[] args) {
        System.out.println("=== WINDOWS ===");
        GUIFactory winFactory = new WinFactory();
        Button winButton = winFactory.createButton();
        winButton.caption = "Play";
        winButton.paint();

        Menu winMenu = winFactory.createMenu();
        //winMenu.caption = "Main Menu";
        winMenu.paint();

        // Mostrar componentes Linux
        System.out.println("\n=== LINUX ===");
        GUIFactory linuxFactory = new LinuxFactory();
        Button linuxButton = linuxFactory.createButton();
        linuxButton.caption = "Play";
        linuxButton.paint();

        Menu linuxMenu = linuxFactory.createMenu();
        //linuxMenu.caption = "Main Menu";
        linuxMenu.paint();
    }

>>>>>>> 1e4c7996c2a22e02abbfff4a34b99d02ef14e579
}
