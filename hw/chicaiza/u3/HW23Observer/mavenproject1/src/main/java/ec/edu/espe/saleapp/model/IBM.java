/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.saleapp.model;

/**
 *
 * @author Chicaiza Michael
 */
public class IBM extends Stock{

    public IBM(String symbol, double price) {      
        this.symbol = symbol;
        this.price = price;

    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {

        this.price = price;
        notifyObservers(new Double(price));

    }
    public String getSymbol() {

        return symbol;
    }
    public void setSymbol(String symbol) {

        this.symbol = symbol;
        notifyObservers(symbol);

    }
    
}
