package ec.edu.espe.model;

/**
 *
 * @author bernardo
 */

public abstract class GUIFactory {
    public static GUIFactory getFactory() {
        int sys = readFromConfigFile("OS_TYPE");
        if (sys == 1)
            return new WinFactory();
        else
            return new LinuxFactory();
    }

    private static int readFromConfigFile(String key) {
        return 0; // mock: 0 = Windows, 1 = Linux
    }

    public abstract Button createButton();
    public abstract Menu createMenu();
}
