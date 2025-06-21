package ec.edu.espe.farm.view;

import ec.edu.espe.farm.model.Chicken;
import ec.edu.espe.farm.model.FarmAnimal;
import ec.edu.espe.farm.model.Food;
import java.util.Date;

/**
 *
 * @author LABS-ESPE
 */
public class Farm {

    private static int egg;

    public static void main(String[] args) {
        System.out.println("My Farm System!");
        int id = 1;
        String breed = "ponedora";
        Date bornOnDate = new Date();
        boolean isMolting = false;
        //read from keyboard
        Food food = new Food("balanceado");
        FarmAnimal farmAnimal;

        farmAnimal = new Chicken(id, breed, bornOnDate, isMolting);

        System.out.println("My Chicken is " + farmAnimal);
        farmAnimal.feed(food);

        Chicken chicken;
        id = 2;
        breed = "dominicano";
        bornOnDate = new Date(2025, 5, 24);
        isMolting = true;

        chicken = new Chicken(id, breed, bornOnDate, isMolting);
        System.out.println("chicken -- " + chicken);
    }
}
