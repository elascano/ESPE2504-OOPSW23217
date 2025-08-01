package ec.edu.espe.model;

/**
 * 
 * @author Tammy Caizapanta
 */

public class LinuxButton extends Button {
    
    @Override
    public void paint() {
        System.out.println("Linux Button: " + caption);
        
    }
}