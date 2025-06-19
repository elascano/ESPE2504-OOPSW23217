package ec.edu.espe.farm.view;


import ec.edu.espe.farm.model.Chicken;
import ec.edu.espe.farm.model.FarmAnimal;
import java.util.Date;



/**
 *
 * @author Carlos Paillacho
 */
public class Farm {
    
    public static void main(String[] args) {
        System.out.println("My Farm System!");
        int id = 1;
        String breed = "Ponedora";
        Date bornOnDate = new Date();
        boolean isMolting = false;
        //readfromkeyword
        Food food = new Food("balanceado");
        
        FarmAnimal farmAnimal;
        
        farmAnimal = new Chicken(id, breed, bornOnDate, isMolting);
        
        System.out.println("My chicken is" +farmAnimal);
        
        farmAnimal.feed(food)
    
    }
    
    
    
}
