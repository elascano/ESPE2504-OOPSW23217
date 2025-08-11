/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.client.model;

/**
 *
 * @author Chicaiza Michael
 */
public class LinuxFactory extends GUIFactory{
    
    @Override
    public Button createButton(){
        return(new LinuxButton());
    }
    
    @Override
    public Menu createMenu(){
        return(new LinuxMenu());
    }
    
    
}
