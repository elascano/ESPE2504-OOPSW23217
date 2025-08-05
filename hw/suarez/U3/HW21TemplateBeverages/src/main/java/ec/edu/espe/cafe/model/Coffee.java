package ec.edu.espe.cafe.model;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author bernardo
 */

public class Coffee extends CaffeineBeverage {
    
    @Override
    public void brew(){
        System.out.println("Dripping coffee through filter\n");
    }
    
    @Override
    public void addCondiments(){
        System.out.println("Adding sugar and milk");
    }
    
    @Override
    public boolean wantsCondiments(){
        String answer = getUserInput();
        
        if(answer.toLowerCase().startsWith ("y")){
            return true;
        } else {
            return false;
        }
    }
    
    private String getUserInput(){
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