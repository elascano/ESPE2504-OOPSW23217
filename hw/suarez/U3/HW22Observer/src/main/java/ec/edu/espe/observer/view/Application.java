package ec.edu.espe.observer.view;
import ec.edu.espe.observer.model.IBM;
import ec.edu.espe.observer.model.Investor;

/**
 *
 * @author BERNARDO
 */
public class Application {

    public static void main(String[] args) {
        Investor s = new Investor("Sorros");
        Investor b = new Investor("Berkshire");

        IBM ibm = new IBM("IBM", 120.00);
        ibm.addObserver(s);
        ibm.addObserver(b);
        ibm.setPrice(100.10);
        ibm.setPrice(100.20);
        ibm.setPrice(100.30);
        ibm.setPrice(100.40);
        ibm.setSymbol("IBMTEST");
    }
}    