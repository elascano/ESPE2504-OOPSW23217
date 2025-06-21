/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espe.farm.view;

import ec.edu.espe.farm.model.Chicken;
import ec.edu.espe.farm.model.FarmAnimal;
import ec.edu.espe.farm.model.Food;
import ec.edu.espe.farm.model.Pig;
import java.util.Date;

/**
 *
 * @author LABS-ESPE
 */
public class Farm {

    public static void main(String[] args) {
        System.out.println("My Farm System!");
        int id = 1;
        String breed = "Ponedora";
        Date bornOnDate = new Date();
        boolean isMolting = false;  
        boolean hasTask = false;
        boolean isProducingMilk = true;
        float milkLittersPerDay = (float) 8.5;
        Date lastSheering = new Date();
        double woolWeightKg = 5;
        //read from keyboard
        Food food = new Food("balanceado");
        FarmAnimal farmAnimal;
        
        farmAnimal = new Chicken(id, breed, bornOnDate, isMolting);
        farmAnimal = new Pig(hasTask, id, breed, bornOnDate);
        farmAnimal = new Pig(hasTask, id, breed, bornOnDate);
        
        System.out.println("My chicken is " + farmAnimal);
    }
}
