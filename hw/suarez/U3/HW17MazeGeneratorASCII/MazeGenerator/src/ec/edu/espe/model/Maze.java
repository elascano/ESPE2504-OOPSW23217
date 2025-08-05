package ec.edu.espe.model;

public class Maze {
    private int rows;
    private int cols;
    private Room[][] rooms;
    private Room entrance;
    private Room exit;

    public Maze(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.rooms = new Room[rows][cols];
        initializeRooms();
    }

    private void initializeRooms() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                rooms[row][col] = new Room(row, col);
            }
        }
    }

    public Room getRoom(int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return null;
        }
        return rooms[row][col];
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public Room getEntrance() {
        return entrance;
    }

    public void setEntrance(Room entrance) {
        this.entrance = entrance;
    }

    public Room getExit() {
        return exit;
    }

    public void setExit(Room exit) {
        this.exit = exit;
    }
}