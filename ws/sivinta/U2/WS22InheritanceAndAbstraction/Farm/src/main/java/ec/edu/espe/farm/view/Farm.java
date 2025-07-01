
package ec.edu.espe.farm.view;

import ec.edu.espe.farm.model.Chicken;
import ec.edu.espe.farm.model.FarmAnimal;
import ec.edu.espe.farm.model.Food;
import ec.edu.espe.farm.model.Pig;
import ec.edu.espe.farm.model.Sheep;
import java.util.Date;

/**
 *
 * @author Sanchez Julio
 */
public class Farm {
    
    public static void main(String[] args){
        System.out.println("My Farm System");
        int id = 1;
        String breed = "ponedora";
        Date bornOnDate = new Date();
        boolean isMolting = false;
        int egg;
        boolean isTimeToSex = true; 
        float weight;

        //read form keyboard
        weight = 13;
        Food food = new Food("balanceado");
        egg = 1;
        FarmAnimal chicken;
        FarmAnimal pig;
        FarmAnimal sheep;
        
        pig = new Pig(weight, isTimeToSex, id, breed, bornOnDate);
        System.out.println(" My pig is " + pig);
        chicken = new Chicken(isMolting, id, breed, bornOnDate, egg);
        System.out.println(" My chicken is " + chicken);
        sheep = new Sheep(bornOnDate, breed, id, breed, bornOnDate);
        System.out.println(" My sheep is " + sheep);

    }
}
