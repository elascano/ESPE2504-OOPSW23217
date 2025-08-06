/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ec.edu.espe.hw23observer.model;

/**
 *
 * @author Micaela Jácome
 */
public class IBM extends Stock {
    private String symbol;
    private double price;

    public IBM(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
        notifyObservers(Double.valueOf(price));
    }

    @Override
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        String oldSymbol = this.symbol;
        this.symbol = symbol;
        notifyObservers("Symbol changed from " + oldSymbol + " to " + symbol);
    }
}

