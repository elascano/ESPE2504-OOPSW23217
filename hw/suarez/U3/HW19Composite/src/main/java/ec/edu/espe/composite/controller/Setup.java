package ec.edu.espe.composite.controller;

import ec.edu.espe.composite.model.*;

/**
 * @author bernardo
 */

public class Setup { // Sets up the org chart and initiates execution

    public static void main(String args[]) {
    // Make manager Able's organization
        Teller lonny = new Teller("Lonny");
        Clerk cal = new Clerk("Cal");
        Manager able = new Manager("Able");
        able.add(lonny);
        able.add(cal);
        
    // Make manager Becky's organization
        Teller juanita = new Teller("Juanita");
        Teller tina = new Teller("Tina");
        Teller thelma = new Teller("Thelma");
        Manager becky = new Manager("Becky");
        becky.add(juanita);
        becky.add(tina);
        becky.add(thelma);

    // Create the president's direct reports
        President pete = President.getPresident("Pete");
        pete.add(able);
        pete.add(becky);
    
    // Initiate client 
        Client.employee = pete;
        Client.doClientTasks();
    }
}
