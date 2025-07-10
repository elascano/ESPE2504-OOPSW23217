
package ec.edu.espe.tutorship.model;

/**
 *
 * @author Mateo Unda
 */
public class H extends A{

    public H(int a) {
        super(a);
    }

    @Override
    public void m() {
        System.out.println("method of class H");    
    }
    
    public void m(E e) {
        System.out.println("method m of class H using e --> " + e);

    }
    
    
}
