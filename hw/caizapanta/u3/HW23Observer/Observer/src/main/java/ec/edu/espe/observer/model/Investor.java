package ec.edu.espe.observer.model;

/**
 *
 * @author Caizapanta Tammy
 */
public class Investor implements IInvestor {

    private String name;

    public Investor(String name) {
        this.name = name;
    }

    @Override
    public void update(Stock stock, Object args) {
        System.out.println("Notified Observer : " + name);
        if (args instanceof String) {
            System.out.println("The symbol of : " + stock.getSymbol() + "Changed to: " + args);
        } else if (args instanceof Double) {
            System.out.println("The Price of : " + stock.getSymbol() + "Changed to: " + args);
        }
    }
}
