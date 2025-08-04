package ec.edu.espe.guifactory.model;

/**
 *
 * @author Bonilla David SoftCrafters
 */
class LinuxFactory entends GUIFactory{ 
    public Button createButton(){ 
        return(new LinuxButton());
    }
    public Menu createMenu() { 
        return(new LinuxMenu());
    }
}