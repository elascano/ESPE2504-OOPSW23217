package ec.edu.espe.templatemethod.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author Bonilla David SoftCrafters
 */
public class Coffee extends CaffeineBeverage {

    public void brew() {
        System.out.println("Dripping coffee through filter");
    }

    public void addCondiments() {
        System.out.println("Adding sugar and milk");
    }

    public boolean wantsCondiments() { // a hook operation 
        String answer = getUserInput();
        if (answer.toLowerCase().startsWith("y")) {
            return true;
        } else {
            return false;
        }
    }

    private String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like milk and sugar with your coffee (y/n)? ");
        String answer = scanner.nextLine();
        return answer;
    }
}
