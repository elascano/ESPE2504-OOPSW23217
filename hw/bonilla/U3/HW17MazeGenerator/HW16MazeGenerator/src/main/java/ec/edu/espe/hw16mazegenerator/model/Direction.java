package ec.edu.espe.hw16mazegenerator.model;

/**
 *
 * @author Bonilla David SoftCrafters
 */
public enum Direction {
    NORTH(-1, 0), SOUTH(1, 0), EAST(0, 1), WEST(0, -1);

    final int rowOffset;
    final int colOffset;

    Direction(int rowOffset, int colOffset) {
        this.rowOffset = rowOffset;
        this.colOffset = colOffset;
    }

    public static Direction opposite(Direction dir) {
        return switch (dir) {
            case NORTH ->
                SOUTH;
            case SOUTH ->
                NORTH;
            case EAST ->
                WEST;
            case WEST ->
                EAST;
        };
    }

    public int getRowOffset() {
        return rowOffset;
    }

    public int getColOffset() {
        return colOffset;
    }

}
