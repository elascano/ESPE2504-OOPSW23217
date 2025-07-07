package ec.edu.espe.tutorship.model;

/**
 *
 * @author Kevin Vaca Edison's OOP ESPE
 */
public abstract class A {
    private int a;

    @Override
    public String toString() {
        return "A{" + "a=" + a + '}';
    }

    public A(int a) {
        this.a = a;
    }
    
    public abstract void m();

    /**
     * @return the a
     */
    public int getA() {
        return a;
    }

    /**
     * @param a the a to set
     */
    public void setA(int a) {
        this.a = a;
    }
}


