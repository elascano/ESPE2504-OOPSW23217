package ec.edu.espe.model;

public class Path {
    private Room from;
    private Room to;

    public Path(Room from, Room to) {
        this.from = from;
        this.to = to;
    }

    public Room getFrom() {
        return from;
    }

    public Room getTo() {
        return to;
    }

    @Override
    public String toString() {
        return "(" + from.getRow() + "," + from.getCol() + ") -> (" + to.getRow() + "," + to.getCol() + ")";
    }
}
