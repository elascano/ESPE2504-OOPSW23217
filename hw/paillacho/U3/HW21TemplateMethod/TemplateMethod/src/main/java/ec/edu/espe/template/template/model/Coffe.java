/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.template.template.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author PC
 */
public class Coffe extends CaffeineBeverage {
    public void brew() {
        System.out.println("Dripping coffee through filter");
    }
    public void addCondimate() {
        System.out.println("Adding sugar and milk");
    }
    public boolean wantsCondimate() {
        String answer = getUserInput();
        if(answer.toLowerCase().startsWith("y")){
            return true;
        } else {
            return false;
        }
    }
    
    private String getUserInput() {
        String answer = null;
        System.out.print("Would you like milk and sugar with your coffee (y/n)? ");
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            answer = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return answer;
    }    
}
