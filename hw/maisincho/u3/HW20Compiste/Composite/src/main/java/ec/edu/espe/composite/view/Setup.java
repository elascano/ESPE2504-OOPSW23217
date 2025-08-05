package ec.edu.espe.composite.view;

import ec.edu.espe.composite.model.Clerk;
import ec.edu.espe.composite.model.Client;
import ec.edu.espe.composite.model.Manager;
import ec.edu.espe.composite.model.President;
import ec.edu.espe.composite.model.Teller;

/**
 *
 * @author Isaac Maisincho Crafters_Market DCCO ESPE
 */
public class Setup {

    public static void main(String[] args) {
        Teller lonny = new Teller("Lonny");
        Clerk cal = new Clerk("Cal");
        Manager able = new Manager("Able");
        able.add(lonny);
        able.add(cal);

        Teller juanita = new Teller("Juanita");
        Teller tina = new Teller("Tina");
        Teller thelma = new Teller("Thelma");
        Manager becky = new Manager("Becky");
        becky.add(juanita);
        becky.add(tina);
        becky.add(thelma);

        President pete = President.getPresident("Pete");
        pete.add(able);
        pete.add(becky);

        Client.employe = pete;
        Client.doClientTasks();

    }
}
