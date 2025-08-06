package ec.edu.espe.model;

/**
 * 
 * @author Tammy Caizapanta
 */

public class LinuxFactory extends GUIFactory {

    @Override
    public Button createButton() {
        return new LinuxButton();
    }

    @Override
    public Menu createMenu() {
        return new LinuxMenu();
    }

}
