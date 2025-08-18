package ec.edu.espe.compositepattern.model;

/**
 *
 * @author Julio Andrade
 */
public class Client {

    public static Employee employee;

    public static void doClientTasks() {
        
        employee.stateName();
    }

    public static void doClientTask() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
