package ec.edu.espe.composite.model;

import ec.edu.espe.composite.controller.Employee;

/**
 *
 * @author Isaac Maisincho Crafters_Market DCCO ESPE
 */
public class Client {

    public static Employee employe;

    public static void doClientTasks() {
        if (employe != null) {
            employe.stateName();
        }
    }
}
