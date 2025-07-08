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
 * @author Quiroz Maria
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
        int numberOfNipples = 4;

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
        Cow cow = new Cow(isProducingMilk, milkProduction, numberOfNipples, idCow, breedCow, bornOnDateCow);

        System.out.println("My cow is " + cow);
        farmAnimal.feed(foodCow);
        System.out.println("Number of Nipples of this " + cow.getClass().getSimpleName() + " is -->");
        System.out.println("breastfeeding a cow --> " + cow.breastfeed(4));
        System.out.println("controling a cow --> " + cow.controlGestation(4));

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
