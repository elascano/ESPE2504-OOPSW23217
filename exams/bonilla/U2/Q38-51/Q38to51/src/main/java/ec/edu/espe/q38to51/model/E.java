package ec.edu.espe.q38to51.model;

/**
 *
 * @author Bonilla David SoftCrafters
 */
public class E {

    private D[] ds = new D[4];
    private C[] cs = new C[3];

    public E() {
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("E: (");
        sb.append("Ds -> ").append(ds.length);
        sb.append(", Cs -> ").append(cs.length);
        sb.append(')');
        return sb.toString();
    }

    public D[] getDs() {
        return ds;
    }

    public void setDs(D[] ds) {
        this.ds = ds;
    }

    public C[] getCs() {
        return cs;
    }

    public void setCs(C[] cs) {
        this.cs = cs;
    }

}
