/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.farm.model;

/**
 *
 * @author LABS-ESPE
 */
public class Food {
    private String description;

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Food{" + "description=" + description + '}';
    }

    public Food(String description) {
        this.description = description;
    }

    
    
    
}
