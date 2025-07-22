package org.example.edu.ec.espe.maze.model;


public class Coordinate {
    private final int row;
    private final int column;
    public Coordinate(int row, int column) { this.row = row; this.column = column; }
    public int getRow() { return row; }
    public int getCol() { return column; }
}
