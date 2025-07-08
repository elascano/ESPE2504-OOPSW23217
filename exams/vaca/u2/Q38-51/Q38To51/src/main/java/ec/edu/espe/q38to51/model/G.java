
package ec.edu.espe.q38to51.model;

/**
 *
 * @author LABS-ESPE
 */
public class G implements H{
    H h;
    G g;
    
    public void m(J j) {
        System.out.println("Method of " + g + "using " + j); 
    }

    @Override
    public void m() {
        System.out.println("Method of g");     
    }
}
