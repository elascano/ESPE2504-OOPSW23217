package ec.edu.espe.chickenfarm.view;

import ec.edu.espe.chickenfarm.model.Chicken;
import java.util.Date;

/**
 *
 * @author Kevin Vaca Edison's OOP ESPE
 */
public class ChickenFarmSimulator {
    
    public static void main(String[] args) {
        
        int id = 1;
        String color = "white and brown";
        String name = "Lucy";
        int age = 10;
        boolean molting = true;
        Date date = new Date();
        
        Chicken chicken = new Chicken(id, name, color, age, molting, date);
        
        System.out.println("Kevin's chicken data --> " + chicken);

    }
}
