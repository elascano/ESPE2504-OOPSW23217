package ec.espe.edu.systemstudents.model;

public class Student {
    private int id;
    private String firstName;

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    private String lastName;
    private int age;

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public float getSalary() {
        return salary;
    }

    private float salary;

    public Student(int id, String firstName, String lastName, int age, int salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " " + age + " " + salary;
    }
}