package ec.edu.espe.tutorship.model;

import java.util.ArrayList;

/**
 *
 * @author Mateo Unda
 */
public class B extends A{

    /**
     * @return the cs
     */
    public ArrayList<C> getCs() {
        return cs;
    }

    /**
     * @param cs the cs to set
     */
    public void setCs(ArrayList<C> cs) {
        this.cs = cs;
    }

    /**
     * @return the d
     */
    public D getD() {
        return d;
    }

    /**
     * @param d the d to set
     */
    public void setD(D d) {
        this.d = d;
    }

    public B(ArrayList<C> cs, D d, int a) {
        super(a);
        this.cs = cs;
        this.d = d;
    }

    @Override
    public String toString() {
        return "B{" + "cs=" + getCs() + ", d=" + getD() + '}';
    }
    
    private ArrayList<C> cs;
    private D d;

    @Override
    public void m() {
        System.out.println("method m of class B");

    }
}
