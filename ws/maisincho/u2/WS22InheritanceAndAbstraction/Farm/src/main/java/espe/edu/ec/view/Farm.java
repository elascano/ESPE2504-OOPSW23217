
package espe.edu.ec.view;

import espe.edu.ec.view.model.Chicken;
import espe.edu.ec.view.model.Cow;
import espe.edu.ec.view.model.FarmAnimal;
import espe.edu.ec.view.model.Food;
import espe.edu.ec.view.model.Pig;
import espe.edu.ec.view.model.Sheep;
import java.util.Date;

/**
 *
 * @author Isaac Maisincho 
 */
public class Farm {


    public static void main(String[] args) {
        System.out.println("My Farm System");

        int id = 1;
        int numberEggs = 2;
        String breed = "ponedora";
        Date bornOnDate = new Date();
        boolean isMolting = false;

        Food food = new Food("balanceado");
        FarmAnimal farmAnimal;
        farmAnimal = new Chicken(isMolting, numberEggs, id, breed, bornOnDate);

        System.out.println("My chicken is " + farmAnimal);
        farmAnimal.feed(food);
        
        Pig pig = new Pig(120.5f, 2, "My Pig", new Date());
        System.out.println(pig);
        pig.feed(food);
        
        Sheep sheep = new Sheep(6.7f, 4, "My Sheep", new Date());
        System.out.println(sheep);
        sheep.feed(food);
        
        Cow cow = new Cow(15.3f, 3, "My Cow", new Date());
        System.out.println(cow);
        cow.feed(food);
    }

    }
