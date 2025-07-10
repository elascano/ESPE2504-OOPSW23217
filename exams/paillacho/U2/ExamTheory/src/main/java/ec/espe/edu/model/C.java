
package ec.espe.edu.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author @author LABS-ESPE
 */
public class C extends A {

    private List<E> es = new ArrayList<>();

    public C() {
        super();
    }

    public void setEs(List<E> es) {
        if (es.size() <= 3) {
            this.es = es;
        }
    }
}
