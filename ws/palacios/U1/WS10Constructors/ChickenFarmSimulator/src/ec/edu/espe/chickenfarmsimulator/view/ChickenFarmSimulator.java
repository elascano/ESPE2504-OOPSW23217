package ec.edu.espe.chickenfarmsimulator.view;

import ec.edu.espe.chickenfarmsimulator.model.Chicken;
import java.util.Date;

/**
 *
 * @author Daniel Palacios
 */
public class ChickenFarmSimulator {

    public static void main(String[] args) {

        int id = 1;
        String color = "white and brown";
        String name = "Lucy";
        int age = 5;
        boolean molting = true;
        Date date = new Date();

        Chicken chicken = new Chicken(id, name, color, age, molting, date);

        System.out.println("Daniel´s chicken data --> " + chicken);
        System.out.println("Daniel´s chicken data --> ");
        chicken.duStuff();

        System.out.println("chicken --> " + chicken.getName() + " is " + chicken.getColor());

        chicken.setAge(12);
        System.out.println(" chicken --> " + chicken.getName() + " is " + chicken.getAge() + " year-old");
        System.out.println("Daniel´s chicken data --> " + chicken);

    }
}
