package ec.edu.espe.chickenfarm.model;

/**
 *
 * @bernardo suarez
 */

import java.util.Date;

public class Chicken {

    public Chicken(int id1, String name1) {
    }

    public Chicken() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMolting() {
        return molting;
    }

    public void setMolting(boolean molting) {
        this.molting = molting;
    }

    public Date getBornOnDate() {
        return bornOnDate;
    }

    public void setBornOnDate(Date bornOnDate) {
        this.bornOnDate = bornOnDate;
    }

    public int id; 
    public String name;
    public String color;
    public int age;
    public boolean molting;
    public Date bornOnDate;
    
    public String toString() {
        return "Chicken{" + "id=" + getId() + ", name=" + getName() + ", color=" + getColor() + ", age=" + getAge() + ", molting=" + isMolting() + ", bornOnDate=" + getBornOnDate() + '}';
    }
      public Chicken(int id, String name, String color, int age, boolean molting, Date bornOnDate) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.age = age;
        this.molting = molting;
        this.bornOnDate = bornOnDate;
    }
    
    public void doStuff() {
        System.out.println("Chicken is -->");
        cluck();
        wander(); 
    }

    private void cluck(){
        System.out.println("Chicken name --> " + getName());
        System.out.println("Chicken date --> "+ getBornOnDate());
        System.out.println("Chicken --> " + getId() + " is clucking");
    }

    private void wander() {
        System.out.println("Chicken --> " + getId() + " is wandering");
    }

    private void eat() {
        System.out.println("Chicken --> " + getId() + " is eating");
    }

    private void drink() {
        System.out.println("Chicken --> " + getId() + " is drinking");
    }

}