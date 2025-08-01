/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.hw21templatemethod.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Micaela Jácome
 */
public class Coffee extends CaffeineBeverage {

    @Override
    public void brew() {
        System.out.println("Dripping coffee through filter");
    }

    @Override
    public void addCondiments() {
        System.out.println("Adding sugar and milk");
    }

    @Override
    public boolean wantsCondiments() {
        String answer = getUserInput();
        if (answer.toLowerCase().startsWith("y")) {
            return true;
        } else {
            return false;
        }
    }

    private String getUserInput() {
        String answer = null;
        System.out.println("Would you like sugar and milk with your coffee (y/n)?");

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            answer = in.readLine();
        } catch (IOException e) {
            System.err.println("IO error trying to read your answer");
        }

        return answer;
    }

}
