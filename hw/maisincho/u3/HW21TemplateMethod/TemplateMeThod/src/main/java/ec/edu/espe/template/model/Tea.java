package ec.edu.espe.template.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Isaac Maisincho Crafters_Market DCCO ESPE
 */
public class Tea extends CaffeineBeverage {

    @Override
    void brew() {
        System.out.println("Steep the tea");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding Lemon");

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
        System.out.println("Would you like lemon on your tea (y/n) ");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            answer = in.readLine();
        } catch (IOException e) {
            System.out.println("Error reading input " + e.getMessage());

        }
        return answer;
    }

}
