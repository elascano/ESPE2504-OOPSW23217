package ec.edu.espe.model;

public class Door extends Wall {
    private Room room1;
    private Room room2;

    public Door(Room room1, Room room2) {
        super();
        this.room1 = room1;
        this.room2 = room2;
    }

    public Room getOtherRoom(Room current) {
        return current == room1 ? room2 : room1;
    }
}
