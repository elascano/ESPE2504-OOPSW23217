package ec.edu.espe.model;

public enum Direction {
    NORTH, EAST, SOUTH, WEST;

    public static Direction opposite(Direction dir) {
        return switch (dir) {
            case NORTH -> SOUTH;
            case EAST -> WEST;
            case SOUTH -> NORTH;
            case WEST -> EAST;
        };
    }
}
