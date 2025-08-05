package ec.edu.espe.mazegenerator.mazegenerator.model;

/**
 *
 * @author LABS-ESPE
 */
public class Path {
    Path path;
    EntranceRoom entranceRoom;
    ExitRoom exitRoom;
    Room[] rooms;
    
    void generate(){
        System.out.println("Generating the path");
    }
}
