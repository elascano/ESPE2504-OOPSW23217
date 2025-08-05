package ec.edu.espe.guifactory.controller;

import ec.edu.espe.guifactory.model.Button;
import ec.edu.espe.guifactory.model.LinuxFactory;
import ec.edu.espe.guifactory.model.Menu;
import ec.edu.espe.guifactory.model.WinFactory;

/**
 *
 * @author Mateo Unda
 */
public abstract class GUIFactory {
    public static GUIFactory getFactory() {
        int sys = readFromConfigFile("OS_TYPE");
    if (sys == 0) {
            return (new WinFactory());
        } else {
            return (new LinuxFactory());
        }
    }

    private static int readFromConfigFile(String os_type) {
        System.out.println("ReadFile");
        return 0;
    }

    public abstract Button createButton();

    public abstract Menu createMenu();
}
