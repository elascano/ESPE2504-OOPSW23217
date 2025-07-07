package ec.edu.espe.q38to51.model;

import java.util.ArrayList;

/**
 *
 * @author Bonilla David SoftCrafters
 */
public class G implements H {

    private ArrayList<B> bs;
    private J j;

    public G(ArrayList<B> bs, J j) {
        this.bs = bs;
        this.j = j;
    }

    @Override
    public void show() {
        System.out.println("I am G implementing H, " + this.toString());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("G have Bs -> ").append(bs.size());
        sb.append(" and use J -> ").append(j.toString());
        return sb.toString();
    }

    public J getJ() {
        return j;
    }

    public void setJ(J j) {
        this.j = j;
    }

    public void setBs(ArrayList<B> bs) {
        this.bs = bs;
    }

    @Override
    public void addB(B b) {
        if (!bs.contains(b)) {
            getBs().add(b);
        }
    }

    @Override
    public ArrayList<B> getBs() {
        return bs;
    }

}
