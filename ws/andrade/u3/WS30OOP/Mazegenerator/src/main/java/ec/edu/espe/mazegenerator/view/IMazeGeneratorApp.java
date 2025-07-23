/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.espe.mazegenerator.view;

/**
 *
 * @author LABS-ESPE
 */
public interface IMazeGeneratorApp {
   @Override
   public  void print(Maze maze){
       System.out.println("Generating a maze of size --->" + maze);
   }
    
    
}
