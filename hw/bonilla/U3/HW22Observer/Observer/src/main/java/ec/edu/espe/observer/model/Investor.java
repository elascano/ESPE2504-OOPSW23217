package ec.edu.espe.observer.model;

/**
 *
 * @author Bonilla David SoftCrafters
 */
public class Investor implements IInvestor {

    private String name;
    private String observerState;
    private Stock stock;

    public Investor(String name) {
        this.name = name;
    }

    public void update(Stock stock, Object args) {
        System.out.println("Notified observer " + name);
        if (args instanceof String) {
            System.out.println("The symbol of " + stock.getSymbol() + " changed to: " + args);
        } else if (args instanceof Double) {
            System.out.println("The price of " + stock.getSymbol() + " changed to: " + args);
        }
    }
}
