package ec.edu.espe.exam;


public class B extends A {

    private A aggregatedA;


    private D associatedD;

    public B(int a, A aggregatedA) {
        super(a);
        this.aggregatedA = aggregatedA;
    }

    public A getAggregatedA() {
        return aggregatedA;
    }

    public void setAggregatedA(A aggregatedA) {
        this.aggregatedA = aggregatedA;
    }

    public D getAssociatedD() {
        return associatedD;
    }

    public void setAssociatedD(D associatedD) {
        this.associatedD = associatedD;
    }
}
