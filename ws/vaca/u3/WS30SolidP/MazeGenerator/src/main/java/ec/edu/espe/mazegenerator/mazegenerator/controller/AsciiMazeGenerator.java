/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.mazegenerator.mazegenerator.controller;

/**
 *
 * @author LABS-ESPE
 */
public class AsciiMazeGenerator implements IMazeGenerator{

    @Override
    public void print() {
        System.out.println("Generating a maze of size-->" + maze);
        }
}
