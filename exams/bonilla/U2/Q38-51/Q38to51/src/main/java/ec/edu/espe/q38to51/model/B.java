package ec.edu.espe.q38to51.model;

import java.util.ArrayList;

/**
 *
 * @author Bonilla David SoftCrafters
 */
public class B extends A {

    private ArrayList<H> h = new ArrayList<>(1);

    public B(ArrayList<A> as) {
        super(as);
    }

    @Override
    public void show() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("B: (");
        sb.append("H -> ").append(h.size());
        sb.append(')');
        return sb.toString();
    }

    public ArrayList<H> getH() {
        return h;
    }

    public void setH(ArrayList<H> h) {
        this.h = h;
    }

}
