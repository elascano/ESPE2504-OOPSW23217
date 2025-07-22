package org.example.edu.ec.espe.maze.model;


public class Wall {
    private boolean isOpen;
    public Wall(boolean isOpen) { this.isOpen = isOpen; }
    public boolean isOpen() { return isOpen; }
    public void setOpen(boolean isOpen) { this.isOpen = isOpen; }
}
