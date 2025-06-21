package ec.edu.espe.farm.view;

import ec.edu.espe.farm.model.Chicken;
import ec.edu.espe.farm.model.FarmAnimal;
import ec.edu.espe.farm.model.Food;
import ec.edu.espe.farm.model.Pig;

import java.util.Date;

/**
 * Main class for the farm system.
 * Author: Carlos Paillacho
 */
public class Farm {
    
    public static void main(String[] args) {
        System.out.println("My Farm System!");

        Date bornOnDate = new Date();
        Food food = new Food("balanceado");

        FarmAnimal chicken = new Chicken(1, "Ponedora", bornOnDate, false);
        FarmAnimal pig = new Pig(2, "Landrace", bornOnDate, 135.5f);

        System.out.println("Chicken info: " + chicken);
        chicken.feed(food);

        System.out.println("Pig info: " + pig);
        pig.feed(food);
    }
}
