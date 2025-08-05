package ec.edu.espe.observer.model;

/**
 *
 * @author Isaac Maisincho Crafters_Market DCCO ESPE
 */
public class IBM extends Stock {

    private String symbol;
    private double price;

    public IBM(String symbol, double price) {
        this.price = price;
        this.symbol = symbol;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
        notifyObservers(symbol);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
        notifyObservers(price);
    }

}
