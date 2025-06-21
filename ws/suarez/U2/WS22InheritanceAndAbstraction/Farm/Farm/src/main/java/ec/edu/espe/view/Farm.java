package ec.edu.espe.view;

import ec.edu.espe.farm.model.FarmAnimal;
import java.util.Date;
import ec.edu.espe.farm.model.Food;
import ec.edu.espe.farm.model.Chicken;
import ec.edu.espe.farm.model.Cow;
import ec.edu.espe.farm.model.Pig;
import ec.edu.espe.farm.model.Sheep;


/**
 *
 * @author BERNARDO SUAREZ
 */
public class Farm {
    public static void main(String[] args){
        System.out.println("| FARM SYSTEM - BS |");
        
        //chicken
        int id = 1;
        String breed = "ponedora";
        Date bornOnDate = new Date();
        boolean isMolting = false;
        int numberOfEggs = 3;
        Food food = new Food("balanceado");
        
        FarmAnimal farmanimal;
        farmanimal = new Chicken(id, breed, bornOnDate,isMolting,numberOfEggs);
        
        System.out.println("1. My farm animal is " + farmanimal);
        farmanimal.feed(food);
        System.out.println("");

        //cow
        id = 2;
        breed = "Holstein";
        bornOnDate = new Date();
        boolean isProducingMilk = true;
        food = new Food ("pasto");
        
        farmanimal = new Cow(id, breed, bornOnDate, isProducingMilk);
        System.out.println("2. My farm animal is " + farmanimal);     
        farmanimal.feed(food);
        System.out.println("");

        //pig
        id = 3;
        breed = "Yorkshire";
        bornOnDate = new Date();
        food = new Food("grano molido");
        
        farmanimal = new Pig(id, breed, bornOnDate);
        System.out.println("3. My farm animal is " + farmanimal);        
        farmanimal.feed(food);
        System.out.println("");
        
        //sheep
        id = 4;
        breed = "Merino";
        bornOnDate = new Date();
        boolean isReadyForShearing = false;
        String lastShearing = "January";
        food = new Food ("heno");
        
        farmanimal = new Sheep(id, breed, bornOnDate, isReadyForShearing, lastShearing);
        System.out.println("4. My farm animal is " + farmanimal);       
        farmanimal.feed(food);
        System.out.println("");
        
    }
}
