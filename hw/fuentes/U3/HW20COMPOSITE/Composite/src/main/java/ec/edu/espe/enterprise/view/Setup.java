/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espe.enterprise.view;

import ec.edu.espe.enterprise.model.Clerk;
import ec.edu.espe.enterprise.model.Manager;
import ec.edu.espe.enterprise.model.President;
import ec.edu.espe.enterprise.model.Teller;
import ec.edu.espe.enterprise.model.Client;

/**
 *
 * @author jorge
 */
public class Setup {

    public static void main(String[] args) {
        Teller lonny = new Teller("Lony");
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
        Client.doClientTask();
        
    }
}
