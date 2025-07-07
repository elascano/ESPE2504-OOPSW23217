/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ec.espe.exam2.model;

/**
 *
 * @author LABS-ESPE
 */
public class F {
    private D d; // Aggregated by D

    public void setD(D d) {
        this.d = d;
    }

    public D getD() {
        return d;
    }

    @Override
    public String toString() {
        return "F{" +
                "d=" + (d != null ? d.getClass().getSimpleName() : "null") +
                '}';
    }
}
