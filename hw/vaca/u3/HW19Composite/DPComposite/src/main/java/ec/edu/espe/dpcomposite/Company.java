package ec.edu.espe.dpcomposite;

/**
 *
 * @author Kevin Vaca Edison's OOP ESPE
 */
public class Company {
    public static void main(String[] args) {
        // Create individual employees
        Employee clerk1 = new Clerk();
        Employee clerk2 = new Clerk();
        Employee teller1 = new Teller();
        Employee teller2 = new Teller();
        Employee supervisor = new Supervisor();
        Employee manager = new Manager();
        Employee president = new President();

        // Create employee groups
        EmployeeGroup clientTeam = new EmployeeGroup("Client Team");
        EmployeeGroup setupTeam = new EmployeeGroup("Setup Team");
        EmployeeGroup allEmployees = new EmployeeGroup("All Employees");

        // Build the client team
        clientTeam.addEmployee(clerk1);
        clientTeam.addEmployee(clerk2);
        clientTeam.addEmployee(teller1);
        clientTeam.addEmployee(teller2);
        clientTeam.addEmployee(supervisor);

        // Build the setup team
        setupTeam.addEmployee(manager);
        setupTeam.addEmployee(president);

        // Combine all teams
        allEmployees.addEmployee(clientTeam);
        allEmployees.addEmployee(setupTeam);

        // Display the hierarchy
        System.out.println("Company Structure:");
        allEmployees.stateName();

        // Display just the client team
        System.out.println("\nClient Team Structure:");
        clientTeam.stateName();
    }
}