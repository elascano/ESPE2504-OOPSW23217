package ec.edu.espe.compositepattern.view;

import ec.edu.espe.compositepattern.model.Clerk;
import ec.edu.espe.compositepattern.model.Manager;
import ec.edu.espe.compositepattern.model.President;
import ec.edu.espe.compositepattern.model.Teller;
import ec.edu.espe.compositepattern.model.Client;

/**
 *
 * @author Micaela Jacome DESKTOP-46VMNHU ESPE
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

        Client.employee = pete;
        Client.doClientTasks(); 
    }
}
