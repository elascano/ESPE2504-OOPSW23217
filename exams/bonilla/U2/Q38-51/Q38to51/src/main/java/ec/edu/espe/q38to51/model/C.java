package ec.edu.espe.q38to51.model;

import java.util.ArrayList;

/**
 *
 * @author Bonilla David SoftCrafters
 */
public class C extends A {

    private ArrayList<E> es;

    public C(ArrayList<E> es, ArrayList<A> as) {
        super(as);
        this.es = es;
    }

    public void addElement(E element) {
        if (es.size() < 3) {
            es.add(element);
        }
    }

    @Override
    public void show() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("C: (");
        sb.append("Es -> ").append(es.size());
        sb.append(')');
        return sb.toString();
    }

    public ArrayList<E> getEs() {
        return es;
    }

    public void setEs(ArrayList<E> es) {
        this.es = es;
    }

}
