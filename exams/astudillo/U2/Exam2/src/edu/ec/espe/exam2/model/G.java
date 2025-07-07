/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ec.espe.exam2.model;

/**
 *
 * @author LABS-ESPE
 */
public class G implements H {
    private J j; // Dependency

    public G() {
    }

    public void setJ(J j) {
        this.j = j;
    }

    public J getJ() {
        return j;
    }

    @Override
    public void doSomething() {
        System.out.println("G is doing something.");
    }

    @Override
    public String toString() {
        return "G{" +
                "j=" + (j != null ? j.getClass().getSimpleName() : "null") +
                '}';
    }
}
