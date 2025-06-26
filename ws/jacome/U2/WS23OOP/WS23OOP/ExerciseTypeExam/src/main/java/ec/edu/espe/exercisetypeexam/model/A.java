package ec.edu.espe.exercisetypeexam.model;

/**
 *
 * @author LABS-ESPE
 */
public abstract class A {
    
    private int a;
    
    public A(int a){
        this.a = a;
    }

    @Override
    public String toString() {
        return "A{" + "a=" + a + '}';
    }
    
    public int getA(){
        return a;
    }
    
    public void setA(int a){
        this.a =a;
    }
}
