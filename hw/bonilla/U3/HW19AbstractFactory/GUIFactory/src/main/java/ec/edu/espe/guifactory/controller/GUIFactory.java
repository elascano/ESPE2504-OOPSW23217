package ec.edu.espe.guifactory.controller;

/**
 *
 * @author Bonilla David SoftCrafters
 */
abstract class GUIFactory {
    public static GUIFactory getFactory() {
        int sys = readFromConfigFile("OS_TYPE");
    if (sys = 0) {
            return (new WinFactory());
        } else {
            return (new LinuxFactory());
        }
    }

    public abstract Button createButton();

    public abstract Menu createMenu();
}
