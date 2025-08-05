
package ec.edu.espe.maze.model;

/**
 *
 * @author Daniel Palacios
 */
public class Room {
    
    //Single Responsibility Principle
    public boolean topWall = true;
    public boolean bottomWall = true;
    public boolean leftWall = true;
    public boolean rightWall = true;
    public boolean visited = false;
}
