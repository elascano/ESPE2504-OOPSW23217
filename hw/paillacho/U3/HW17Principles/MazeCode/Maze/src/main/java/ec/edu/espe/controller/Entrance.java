package ec.edu.espe.controller;

/**
 *
 * @author Carlos Paillacho
 */
public class Entrance extends Door {
    public Entrance(Room from) {
        super(from, null);
    }

    @Override
    public boolean isExterior() {
        return true;
    }
}