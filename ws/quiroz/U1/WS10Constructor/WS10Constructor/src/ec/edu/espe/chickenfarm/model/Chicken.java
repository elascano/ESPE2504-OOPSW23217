package ec.edu.espe.chickenfarm.model;

import java.util.Date;


/**
 *
 * @author Maria Quroz
 */
public class Chicken {

    public Chicken(int id1, String name1) {
    }

    public Chicken() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the molting
     */
    public boolean isMolting() {
        return molting;
    }

    /**
     * @param molting the molting to set
     */
    public void setMolting(boolean molting) {
        this.molting = molting;
    }

    /**
     * @return the bornOnDate
     */
    public Date getBornOnDate() {
        return bornOnDate;
    }

    /**
     * @param bornOnDate the bornOnDate to set
     */
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
        System.out.println("Chicken --> " + getId() + "is clucking");
    }

    private void wander() {
        System.out.println("Chicken --> " + getId() + "is wandering");
    }

    private void eat() {
        System.out.println("Chicken --> " + getId() + "is eating");
    }

    private void drink() {
        System.out.println("Chicken --> " + getId() + "is drinking");
    }

}
