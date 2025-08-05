package ec.edu.espe.observer.model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Jahir Sivinta DCCO
 */
public abstract class Stock {

    protected String symbol;
    protected double price;
    private ArrayList investors = new ArrayList();

    public Stock() {
    }

    public void addObserver(IInvestor iinvestor) {
        investors.add(iinvestor);
    }

    public void deleteObserver(IInvestor iinvestor) {
        investors.remove(iinvestor);
    }

    public void notifyObservers(Object args) {
        Iterator i = investors.iterator();
        while (i.hasNext()) {
            IInvestor investor = (IInvestor) i.next();
            investor.update(this, args);
        }
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ArrayList getInvestors() {
        return investors;
    }

    public void setInvestors(ArrayList investors) {
        this.investors = investors;
    }
    
}
