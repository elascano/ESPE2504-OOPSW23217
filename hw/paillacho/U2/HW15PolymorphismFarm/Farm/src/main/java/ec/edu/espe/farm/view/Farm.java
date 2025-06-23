package ec.edu.espe.farm.view;

import ec.edu.espe.farm.model.Chicken;
import ec.edu.espe.farm.model.Cow;
import ec.edu.espe.farm.model.FarmAnimal;
import ec.edu.espe.farm.model.Food;
import ec.edu.espe.farm.model.Pig;
import ec.edu.espe.farm.model.Sheep;

import java.util.Date;

/**
 * Main class for the farm system.
 * Autor: Carlos Paillacho
 */
public class Farm {
    
    public static void main(String[] args) {
        System.out.println("My Farm System!");

        Date bornOnDate = new Date();
        Food food = new Food("balanceado");

        FarmAnimal chicken = new Chicken(1, "Ponedora", bornOnDate, false);
        FarmAnimal pig = new Pig(2, "Landrace", bornOnDate, 135.5f);
        FarmAnimal sheep = new Sheep(3, "Merina", bornOnDate, new Date());
        FarmAnimal cow = new Cow(4, "Holstein", bornOnDate, 25.0f);

        System.out.println("\nChicken info: " + chicken);
        chicken.feed(food);

        System.out.println("\nPig info: " + pig);
        pig.feed(food);

        System.out.println("\nSheep info: " + sheep);
        sheep.feed(food);

        System.out.println("\nCow info: " + cow);
        cow.feed(food);
    }
}
