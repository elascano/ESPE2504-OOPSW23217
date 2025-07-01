package ec.edu.espe.farm.view;
import ec.edu.espe.farm.model.Chicken;
import ec.edu.espe.farm.model.FarmAnimal;
import ec.edu.espe.farm.model.Food;
import ec.edu.espe.farm.model.Pig;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Kevin Vaca
 */
public class Farm {
    
    public static void main(String[] args) {
        System.out.println("My farm system.");
        
        int id = 1;
        String breed = "ponedora";
        Date bornOnDate = new Date();
        ArrayList<FarmAnimal> animals;
        
        animals = new ArrayList<>();
        
        System.out.println("-------ANIMALS------");
        System.out.println("    Animals --> " + animals);
        
        
        boolean isMolting = false;
        
        //read from keyboard
        Food food = new Food("balanceado");
        
        FarmAnimal farmAnimal;
        
        farmAnimal = new Chicken (id, breed, bornOnDate, isMolting);
        
        
        System.out.println("My Animal is " + farmAnimal);
        
        farmAnimal.feed(food);
        
        addAndPrintAnimals(animals, farmAnimal);
        
        Chicken chicken;
        
        id=2;
        breed="dominicano";
        bornOnDate=new Date(2025, 05, 24);
        
        isMolting = true;
        
        LocalDate localDate;
        LocalTime localTime;
        LocalDateTime localDateTime;
        
        chicken = new Chicken (id, breed, bornOnDate, isMolting);
        addAndPrintAnimals(animals, chicken);
        
        System.out.println("Chicken -> " + chicken);
        
        System.out.println("farmAnimal type --> " + chicken.getClass());
        
        Pig pig;

        id=3;
        breed = "miniPig";
        bornOnDate = new Date(105, 11, 17);
                
        pig = new Pig (id, breed, bornOnDate);
        addAndPrintAnimals(animals, pig);

        System.out.println("Pig -> " + pig);
        System.out.println("My Animal is " + pig);
        
        if (farmAnimal instanceof Chicken){
            System.out.println("I am a Chicken -->" + farmAnimal);
        } else {
            System.out.println(farmAnimal + "is not a Chicken");
        }
        
        id =4;
        breed = "Duroc";
        bornOnDate = new Date();
        
        Pig pig2;
        pig2 = new Pig (id, breed, bornOnDate);
        addAndPrintAnimals(animals, pig2);
       }
    
    private static void addAndPrintAnimals(ArrayList<FarmAnimal> animals, FarmAnimal animal) {
        animals.add(animal);
        System.out.println("-------ANIMALS------");
        animals.forEach(System.out::println);
        System.out.println("    Animals --> " + animals);
    }
}