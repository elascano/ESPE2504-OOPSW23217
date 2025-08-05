package ec.edu.espe.observer.model;

/**
 * Observer interface for the Observer pattern
 * @author Gerald Astudillo
 */
public interface IInvestor {
    void update(Stock stock, Object args);
}
