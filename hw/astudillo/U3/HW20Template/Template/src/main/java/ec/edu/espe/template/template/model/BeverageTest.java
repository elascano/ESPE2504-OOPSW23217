/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.template.template.model;

import ec.edu.espe.template.template.model.Coffe;
import ec.edu.espe.template.template.model.Tea;

/**
 *
 * @author PC
 */
public class BeverageTest {
    public static void main(String[] args){
        Tea tea = new Tea();
        Coffe coffe = new Coffe();
        
        System.out.println("Making Tea ...");
        tea.prepareRecipe();
        
        System.out.println("\nMaking coffee ..." ); 
        coffe.prepareRecipe();
    }
}
