package ec.edu.espe.composite.composite.model;

public class Client {
    public static Employee employee;
    
    public static void doClientTasks() {
        employee.stateName(employee.title, employee.name);
    }
}
