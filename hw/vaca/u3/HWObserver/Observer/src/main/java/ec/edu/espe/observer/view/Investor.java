/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.observer.view;

import ec.edu.espe.observer.model.Stock;

/**
 *
 * @author LABS-ESPE
 */
public class Investor implements IInvestor {
    private String name;

    public Investor(String name) {
        this.name = name;
    }

    @Override
    public void update(Stock stock, Object arg) {
        System.out.println("Notified observer " + name);
        if (arg instanceof Double) {
            System.out.println("The price of " + stock.getSymbol() + " changed to: " + arg);
        } else if (arg instanceof String) {
            System.out.println("The symbol of " + stock.getSymbol() + " changed to: " + arg);
        }
    }
}
