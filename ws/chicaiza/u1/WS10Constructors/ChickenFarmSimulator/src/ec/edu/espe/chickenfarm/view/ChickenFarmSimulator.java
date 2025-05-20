package ec.edu.espe.chickenfarm.view;

import ec.edu.espe.chickenfarm.model.Chicken;
import java.util.Date;

/**
 *
 * @author Chicaiza Michael
 */
public class ChickenFarmSimulator {
    public static void main(String[]args){
        int id=1;
        String color = "white and brown";
        String name = "Lucy";
        int age = 5;
        boolean molting = true;
        Date date = new Date();
        
        Chicken chicken=new Chicken(id,name,color,age,molting,date);
        System.out.println("Chicaiza´s chicken data -->"+chicken);
        System.out.println("Chicaiza´s chicken data -->");
        chicken.duStuff();
        
        System.out.println("chicken -->"+chicken.getName()+"is"+chicken.getColor());
        
        chicken.setAge(12);
        System.out.println("chicken -->"+chicken.getName()+"is"+chicken.getAge()+"years-old");
        System.out.println("Chicaiza´s chicken data -->"+chicken);
        
    }
}
