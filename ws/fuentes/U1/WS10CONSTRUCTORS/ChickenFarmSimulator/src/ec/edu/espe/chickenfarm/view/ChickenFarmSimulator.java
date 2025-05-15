package ec.edu.espe.chickenfarm.view;

import ec.edu.espe.chickenfarm.model.Chicken;
import java.util.Date;

/**
 *
 * @author Jorge Fuentes
 */
public class ChickenFarmSimulator {
    public static void main(String[]args){
        int id=1;
        String color="White and brown";
        String name="Lucy";
        int age=5;
        boolean molting=true;
        Date date=new Date();
        
        Chicken chicken=new Chicken(id, name, color, age, molting, date);
        
        System.out.println("Jorge´s chicken data -->" + chicken);
        System.out.println("Jorge´s chicken data -->");
        chicken.doStuff();
                
        System.out.println("chicken --> " + chicken.getName() + " is " + chicken.getColor());
        
        chicken.setAge(12);
        System.out.println("Chicken --> " + chicken.getName() + " is " + chicken.getAge() + "Year-old");
        System.out.println("Jorge´s chicken data --> " + chicken);
    }
    
}
