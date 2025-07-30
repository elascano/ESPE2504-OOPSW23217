package ec.edu.espe.abstractFactory.controller;

import ec.edu.espe.abstractFactory.model.Button;

/**
 *
 * @author Isaac Maisincho Crafters_Market DCCO ESPE
 */
public class LinuxButton extends Button {

    @Override
    public void paint() {
        System.out.println("I'm a Linux Button: " + caption);
    }

}
