package ec.edu.espe.model;

/**
 * 
 * @author Tammy Caizapanta
 */

public class WinButton extends Button {
    
    @Override
    public void paint() {
        System.out.println("Windows Button: " + caption);
        
    }
}