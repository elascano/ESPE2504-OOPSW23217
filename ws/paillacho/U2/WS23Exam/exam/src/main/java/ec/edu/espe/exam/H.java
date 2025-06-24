package ec.edu.espe.exam;


public class H extends A {

    private A aggregatedA;

    public H(int a, A aggregatedA) {
        super(a);
        this.aggregatedA = aggregatedA;
    }

    public A getAggregatedA() {
        return aggregatedA;
    }

    public void setAggregatedA(A aggregatedA) {
        this.aggregatedA = aggregatedA;
    }
}
