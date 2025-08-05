package ec.edu.espe.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 *
 * @author Carlos Paillacho
 */
public class Path {
    private final List<Room> pathRooms = new ArrayList<>();

    public void addStep(Room room) {
        pathRooms.add(room);
    }

    public List<Room> getPathRooms() {
        return Collections.unmodifiableList(pathRooms);
    }
}
