package ec.espe.edu.model;

import ec.espe.edu.controller.H;
import java.util.List;

/**
 *
 * @author @author LABS-ESPE
 */
public class B extends A {

    private List<H> hs;

    public void B(List<H> hs) {
        this.hs = hs;
    }

    public List<H> getHs() {
        return hs;
    }

}
