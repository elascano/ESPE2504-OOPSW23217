
package ec.edu.espe.chickenfarmersimulator.view;
import ec.edu.espe.chickenfarmersimulator.model.Chicken;
import java.util.Date;

/**
 *
 * @author Sanchez Julio
 */
public class ChickenFarm {
    public static void main(String[] args) {
        int id = 1;
        String color = "white and brown";
        String name = "Lucy";
        int age = 5;
        boolean molting = true;
        Date date = new Date();
        
        Chicken chicken = new Chicken(id, name, color, age, molting, date);
        
        System.out.println("Julio Esteban´s chicken data --> " + chicken);
        System.out.println("Julio Esteban´s chicken data --> "  );
        chicken.duStuff();
        
        System.out.println("chicken --> " + chicken.getName() + " is " + chicken.getColor());
        
        chicken.setAge(12);
        System.out.println("chicken --> " + chicken.getName() + " is " + chicken.getAge() + " year-old");
        System.out.println("Julio Esteban´s chicken data --> " + chicken);
       

    }
    
}
        
    }
}
