package ec.edu.espe.observer.model;

/**
 * Concrete Subject in the Observer pattern
 * @author Gerald Astudillo
 */
public class IBM extends Stock {
    private String symbol;
    private double price;

    public IBM(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
        notifyObservers(Double.valueOf(price));
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        String oldSymbol = this.symbol;
        this.symbol = symbol;
        notifyObservers("Symbol changed from " + oldSymbol + " to " + symbol);
    }
}
