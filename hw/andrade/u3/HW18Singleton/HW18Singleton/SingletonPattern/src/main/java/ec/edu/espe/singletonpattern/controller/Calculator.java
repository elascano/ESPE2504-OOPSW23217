/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.singletonpattern.controller;

import ec.edu.espe.singletonpattern.model.USTax;

/**
 *
 * @author Micaela Jácome
 */
public class Calculator {

    public float salesTotal(float subtotal) {
        float total;
        float tax;
        tax = subtotal * USTax.getInstance().getTaxPercentage();
        total = subtotal + tax;
        return total;
    }
}
