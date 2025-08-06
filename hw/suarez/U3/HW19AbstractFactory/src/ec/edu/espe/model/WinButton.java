package ec.edu.espe.model;

/**
 *
 * @author bernardo
 */

public class WinButton extends Button {
    
    @Override
    public void paint() {
        System.out.println("WinButton --> " + caption);
        
    }
}