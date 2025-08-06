package ec.edu.espe.observer.model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Caizapanta Tammy
 */
public abstract class Stock {

    private String symbol;
    private double price;
    private ArrayList<IInvestor> investors = new ArrayList<>();

    public Stock() {

    }

    public void addObserver(IInvestor iinvestor) {
        investors.add(iinvestor);
    }

    public void deleteObserver(IInvestor iinvestor) {
        investors.remove(iinvestor);
    }

    public void notifyObservers(Object args) {
        Iterator<IInvestor> i = investors.iterator();
        while (i.hasNext()) {
            IInvestor investor = i.next();
            investor.update(this, args);
        }
    }

    public abstract String getSymbol();

}
