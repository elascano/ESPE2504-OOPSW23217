package ec.edu.espe.abstractFactory.model;

/**
 *
 * @author Isaac Maisincho Crafters_Market DCCO ESPE
 */
public class LinuxMenu extends Menu {

    @Override
    public void paint() {
        System.out.println("I'm a WinMenu: " + caption);
    }

}
