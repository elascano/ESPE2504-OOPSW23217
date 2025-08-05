package ec.edu.espe.observer.controller;

import ec.edu.espe.observer.model.IBM;
import ec.edu.espe.observer.view.Investor;

/**
 *
 * @author LABS-ESPE
 */
public class Main {

    public static void main(String[] args) {
        IBM ibm = new IBM("IBM", 120.00);

        Investor investor1 = new Investor("Sorros");
        Investor investor2 = new Investor("Berkshire");

        ibm.addObserver(investor1);
        ibm.addObserver(investor2);

        ibm.setPrice(120.10);
        ibm.setPrice(121.00);
        ibm.setPrice(120.50);
        ibm.setPrice(120.75);
        ibm.setSymbol("IBMTEST");
    }
}