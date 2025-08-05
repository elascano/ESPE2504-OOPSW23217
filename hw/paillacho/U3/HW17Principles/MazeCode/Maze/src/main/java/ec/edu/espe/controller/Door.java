package ec.edu.espe.controller;

/**
 *
 * @author Carlos Paillacho
 */
public abstract class Door {
    protected final Room from;
    protected final Room to;

    public Door(Room from, Room to) {
        this.from = from;
        this.to = to;
    }

    public Room getFrom() {
        return from;
    }

    public Room getTo() {
        return to;
    }

    public abstract boolean isExterior();
}