package ec.edu.espe.correction.model;

import java.util.ArrayList;

/**
 *
 * @author LABS-ESPE
 */
public class B extends A {
    private ArrayList <H> hs;

    public B(ArrayList<A> as) {
        super(as);
    }
    
    public void r() {
        H h;
        System.out.println("");
    }

    /**
     * @return the hs
     */
    public ArrayList <H> getHs() {
        return hs;
    }

    /**
     * @param hs the hs to set
     */
    public void setHs(ArrayList <H> hs) {
        this.hs = hs;
    }
}
