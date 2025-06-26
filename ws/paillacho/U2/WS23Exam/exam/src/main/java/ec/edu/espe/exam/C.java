package ec.edu.espe.exam;


public class C extends B {

    private B aggregatedB;

    public C(int a, A aForSuper, B aggregatedB) {
        super(a, aForSuper);
        this.aggregatedB = aggregatedB;
    }

    public B getAggregatedB() {
        return aggregatedB;
    }

    public void setAggregatedB(B aggregatedB) {
        this.aggregatedB = aggregatedB;
    }
}
