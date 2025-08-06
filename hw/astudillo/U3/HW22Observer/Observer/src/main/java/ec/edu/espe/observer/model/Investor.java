package ec.edu.espe.observer.model;

/**
 * Concrete Observer in the Observer pattern
 * @author Gerald Astudillo
 */
public class Investor implements IInvestor {
    private String name;

    public Investor(String name) {
        this.name = name;
    }

    public void update(Stock stock, Object args) {
        System.out.println("Notified observer " + name);
        if (args instanceof String) {
            System.out.println(args);
        } else if (args instanceof Double) {
            System.out.println("The price of " + stock.getSymbol() + " changed to: " + args);
        }
    }
}
