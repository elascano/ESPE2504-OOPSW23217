package ec.edu.espe.observer.model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Subject (Observable) in the Observer pattern
 * @author Gerald Astudillo
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
