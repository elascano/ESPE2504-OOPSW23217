package ec.edu.espe.guifactory.model;

import ec.edu.espe.guifactory.controller.GUIFactory;
import ec.edu.espe.guifactory.view.LinuxButton;
import ec.edu.espe.guifactory.view.LinuxMenu;

/**
 *
 * @author Jahir Sivinta DDCO
 */
public class LinuxFactory extends GUIFactory{ 
    public Button createButton(){ 
        return(new LinuxButton());
    }
    public Menu createMenu() { 
        return(new LinuxMenu());
    }
}