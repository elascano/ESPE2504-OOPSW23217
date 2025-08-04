package ec.edu.espe.model;

/**
 * 
 * @author Tammy Caizapanta
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
        return 0;
    }

    public abstract Button createButton();
    public abstract Menu createMenu();
}
