package ec.edu.espe.q38to51.model;

import java.util.ArrayList;

/**
 *
 * @author Bonilla David SoftCrafters
 */
public abstract class A {

    private ArrayList<A> as;

    public A(ArrayList<A> as) {
        this.as = as;
    }

    public abstract void show();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("A: ");
        sb.append("(as -> ").append(as.size());
        sb.append(')');
        return sb.toString();
    }

    public ArrayList<A> getAs() {
        return as;
    }

    public void setAs(ArrayList<A> as) {
        this.as = as;
    }

}
