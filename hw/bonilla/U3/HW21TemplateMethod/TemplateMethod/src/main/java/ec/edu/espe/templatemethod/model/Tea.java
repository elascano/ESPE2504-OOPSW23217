package ec.edu.espe.templatemethod.model;

import java.util.Scanner;

/**
 *
 * @author Bonilla David SoftCrafters
 */
public class Tea extends CaffeineBeverage {

    public void brew() {
        System.out.println("Steep the tea");
    }

    public void addCondiments() {
        System.out.println("Adding lemon");
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
        System.out.println("Would you like lemon with your tea (y/n)? ");
        String answer = scanner.nextLine();
        return answer;
    }
}
