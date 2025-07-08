package ec.edu.espe.q38to51.model;

import java.util.ArrayList;

/**
 *
 * @author Bonilla David SoftCrafters
 */
public class D extends A {

    private ArrayList<F> fs;
    private E[] es = new E[5];

    public D(E[] es, ArrayList<F> f, ArrayList<A> as) {
        super(as);
        this.es = es;
        this.fs = f;
    }

    @Override
    public void show() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("D: (");
        sb.append("Fs -> ").append(fs.size());
        sb.append(", Es -> ").append(es.length);
        sb.append(')');
        return sb.toString();
    }

    public ArrayList<F> getF() {
        return fs;
    }

    public void setF(ArrayList<F> f) {
        this.fs = f;
    }

    public E[] getEs() {
        return es;
    }

    public void setEs(E[] es) {
        this.es = es;
    }

}
