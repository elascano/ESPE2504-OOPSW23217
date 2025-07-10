
package ec.espe.edu.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author @author LABS-ESPE
 */
public abstract class A {
    
    private A relatedA;
    private List<A> As=new ArrayList<>();
   
    public A getRelatedA() {
        return relatedA;
    }

    public void setRelatedA(A relatedA) {
        this.relatedA = relatedA;
    }

    public List<A> getAs() {
        return As;
    }

    public void setAs(List<A> As) {
        this.As = As;
    }


    
}
