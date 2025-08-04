package ec.edu.espe.guifactory.view;

import java.awt.Button;

/**
 *
 * @author Bonilla David SoftCrafters
 */
class LinuxButton extends Button {

    public void paint() {
        System.out.println("I'm a LinuxButton: " + caption);
    }
}
