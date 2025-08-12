/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ec.edu.espe.hw23observer.model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Tammy Caizapanta
 */
public abstract class Stock {
    protected String symbol;
    protected double price;
    private ArrayList<IInvestor> investors = new ArrayList<>();

    public Stock() {}

    public void addObserver(IInvestor investor) {
        investors.add(investor);
    }

    public void deleteObserver(IInvestor investor) {
        investors.remove(investor);
    }

    public void notifyObservers(Object args) {
        Iterator<IInvestor> i = investors.iterator();
        while (i.hasNext()) {
            IInvestor investor = i.next();
            investor.update(this, args);
        }
    }

    public abstract String getSymbol();
    public abstract double getPrice();
}

