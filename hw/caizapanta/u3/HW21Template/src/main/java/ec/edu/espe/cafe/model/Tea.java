package ec.edu.espe.cafe.model;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author Tammy Caizapanta
 */

public class Tea extends CaffeineBeverage{
    
    @Override
    public void brew(){
        System.out.println("Steep the tea");
    }
    
    @Override
    public void addCondiments(){
        System.out.println("Adding lemon");
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
    System.out.println("Would you like lemon with your tea (y/n)?");

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    try {
        answer = in.readLine();
    } catch (IOException e) {
        System.err.println("error when reading answer");
    }

    return answer;
    }
}