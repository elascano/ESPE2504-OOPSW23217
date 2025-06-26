package ec.edu.espe.farm.view;

import ec.edu.espe.farm.model.Chicken;
import ec.edu.espe.farm.model.FramAnimal;
import ec.edu.espe.farm.model.Food;
import java.util.Date;

/**
 *
 * @author LABS-ESPE
 */
public class Farm {

    public static void main(String[] agrs){
        System.out.println("My farm system.");
        int id = 1;
        String breed = "ponedora";
        Date bornOnDate = new Date();
        boolean isMolting = false;
        
        Food food = new Food("Balanceado");
        
        FramAnimal framAnimal;
        
        framAnimal = new Chicken (id, breed, bornOnDate, isMolting);
        
        System.out.println("My chicken is" +farmAnimal);
        
        farmAnimal.feed(food);
    }
    
}

