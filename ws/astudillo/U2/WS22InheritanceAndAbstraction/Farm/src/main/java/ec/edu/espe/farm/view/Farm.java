package ec.edu.espe.farm.view;

import ec.edu.espe.farm.model.Chicken;
import ec.edu.espe.farm.model.Cow;
import ec.edu.espe.farm.model.FarmAnimal;
import ec.edu.espe.farm.model.Food;
import ec.edu.espe.farm.model.Pig;
import ec.edu.espe.farm.model.Sheep;
import java.util.Date;

/**
 *
 * @author Bonilla David Softcrafters
 */
public class Farm {

    public static void main(String[] args) {

        System.out.println("My Farm System!");

        //Chicken Attributes
        int id = 1;
        int numberEggs = 2;
        String breed = "ponedora";
        Date bornOnDate = new Date();
        boolean isMolting = false;

        //Cow Attributes
        boolean isProducingMilk = true;
        float milkProduction = 12;
        int idCow = 2;
        String breedCow = "criolla";
        Date bornOnDateCow = new Date();

        //Píg Attributes
        float mudLevel = 14.5f;
        int idPig = 3;
        String breedPig = "black";
        Date bornOnDatePig = new Date();

        //Sheep Attributes
        Date lastSheering = new Date();
        float woolLength = 123.5f;
        int idSheep = 4;
        String breedSheep = "Ovis orientails aries";
        Date bornOn = new Date();

        //CHICKEN
        Food food = new Food("balanceado");
        FarmAnimal farmAnimal;
        farmAnimal = new Chicken(isMolting, numberEggs, id, breed, bornOnDate);
        System.out.println("My chicken is " + farmAnimal);
        farmAnimal.feed(food);

        //COW
        Food foodCow = new Food("boil");
        farmAnimal = new Cow(isProducingMilk, milkProduction, idCow, breedCow, bornOnDateCow);
        System.out.println("My cow is " + farmAnimal);
        farmAnimal.feed(foodCow);

        //PIG
        Food foodPig = new Food("vegetables");
        farmAnimal = new Pig(mudLevel, idPig, breedPig, bornOnDatePig);
        System.out.println("My pig is " + farmAnimal);
        farmAnimal.feed(foodPig);

        //SHEEP
        Food foodSheep = new Food("forage");
        farmAnimal = new Sheep(lastSheering, woolLength, idSheep, breedSheep, bornOn);
        System.out.println("My pig is " + farmAnimal);
        farmAnimal.feed(foodSheep);
    }

}
