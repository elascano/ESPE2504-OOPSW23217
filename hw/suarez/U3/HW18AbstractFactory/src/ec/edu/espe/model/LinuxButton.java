package ec.edu.espe.model;

/**
 *
 * @author bernardo
 */

public class LinuxButton extends Button {
    
    @Override
    public void paint() {
        System.out.println("LinuxButton --> " + caption);
        
    }
}