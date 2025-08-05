package ec.edu.espe.controller;

/**
 *
 * @author Carlos Paillacho
 */
public class Exit extends Door {
    public Exit(Room from) {
        super(from, null);
    }

    @Override
    public boolean isExterior() {
        return true;
    }
}
