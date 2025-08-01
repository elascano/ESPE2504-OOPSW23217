package ec.edu.espe.guifactory.view;

import ec.edu.espe.guifactory.model.Button;


/**
 *
 * @author José Yánez
 */
public class LinuxButton extends Button {

    public void paint() {
        System.out.println("I'm a LinuxButton: " + caption);
    }
}
