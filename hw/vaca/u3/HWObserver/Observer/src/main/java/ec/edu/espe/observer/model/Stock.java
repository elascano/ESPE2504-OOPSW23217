/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.observer.model;

import ec.edu.espe.observer.view.IInvestor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LABS-ESPE
 */
public abstract class Stock {
    protected String symbol;
    protected double price;
    private List<IInvestor> observers = new ArrayList<>();

    public void addObserver(IInvestor investor) {
        observers.add(investor);
    }

    public void deleteObserver(IInvestor investor) {
        observers.remove(investor);
    }

    public void notifyObservers(Object arg) {
        for (IInvestor investor : observers) {
            investor.update(this, arg);
        }
    }

    public String getSymbol() {
        return symbol;
    }

    public double getPrice() {
        return price;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
        notifyObservers(symbol);
    }
}
