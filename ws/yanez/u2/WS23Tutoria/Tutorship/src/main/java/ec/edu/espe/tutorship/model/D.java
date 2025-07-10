package ec.edu.espe.tutorship.model;

/**
 *
 * @author Jose Yanez Edison's OOP ESPE
 */
public class D {

    /**
     * @return the es
     */
    public E[] getEs() {
        return es;
    }

    /**
     * @param es the es to set
     */
    public void setEs(E[] es) {
        this.es = es;
    }
    
    private E es[] = new E[10];

    public D(E[] es) {
        this.es = es;
    }

    
    public void m(G g) {
        System.out.println("receiving " + g + " to method m()");
    }
    
}
