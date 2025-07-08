package ec.edu.espe.farm.view;
import ec.edu.espe.farm.model.Chicken;
import ec.edu.espe.farm.model.FarmAnimal;
import ec.edu.espe.farm.model.Food;
import java.util.Date;

/**
 *
 * @author Jose Yanez
 */
public class Farm {
    
    public static void main(String[] args) {
        
        System.out.println("My farm system.");
        int id = 1;
        String breed = "ponedora";
        Date bornOnDate = new Date();
        boolean isMolting = false;
        
        //read from keyboard
        Food food = new Food("balanceado");
        
        FarmAnimal farmAnimal;
        
        farmAnimal = new Chicken (id, breed, bornOnDate, isMolting);
        
        System.out.println("My chicken is " + farmAnimal);
        
        farmAnimal.feed(food);
        
    }
    
}