package ec.edu.espe.composite.controller;

import ec.edu.espe.composite.model.Employee;

/**
 *
 * @author Carlos Paillacho
 */
public class Client {
    /**
     * This class relates to a specific Employee instance.
     */
    public static Employee employee;

    /**
     * Perform tasks on the assigned Employee.
     */
    public static void doClientTasks() {
        if (employee != null) {
            employee.stateName();
        }
    }
}