package ec.edu.espe.exercisetypeexam.model;

import java.util.ArrayList;

/**
 *
 * @author LABS-ESPE
 */
public class B extends A{

    @Override
    public String toString() {
        return "B{" + "c=" + c + ", d=" + d + '}';
    }
    private ArrayList<C>c;
    private D d;
    public B(int a) {
        super(a);
    }
    
}
