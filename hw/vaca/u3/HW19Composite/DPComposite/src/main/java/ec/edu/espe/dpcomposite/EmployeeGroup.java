/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.dpcomposite;

import java.util.ArrayList;
import java.util.List;

public class EmployeeGroup implements Employee {
    private String groupName;
    private List<Employee> employees = new ArrayList<>();

    public EmployeeGroup(String groupName) {
        this.groupName = groupName;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    @Override
    public void stateName() {
        System.out.println("Group: " + groupName);
        for (Employee employee : employees) {
            employee.stateName();
        }
    }
}
