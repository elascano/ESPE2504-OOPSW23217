package ec.edu.espe.correction.model;

import java.util.ArrayList;

/**
 *
 * @author LABS-ESPE
 */
public class A {                //0.5
    private ArrayList<A> as;    //0.4
                                //encapsulation, 
                                //constructor and toString 0.1
    @Override
    public String toString() {
        return "A{" + "as=" + as + '}';
    }

    public A(ArrayList<A> as) {
        this.as = as;
    }

    /**
     * @return the as
     */
    public ArrayList<A> getAs() {
        return as;
    }

    /**
     * @param as the as to set
     */
    public void setAs(ArrayList<A> as) {
        this.as = as;
    }
    
    
}
