/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espe.hw23observer.view;

import ec.edu.espe.hw23observer.model.IBM;
import ec.edu.espe.hw23observer.model.Investor;

/**
 *
 * @author Tammy Caizapanta
 */
public class Application {

    public static void main(String[] args) {
        Investor s = new Investor("Sorros");
        Investor b = new Investor("Berkshire");

        IBM ibm = new IBM("IBM", 120.00);
        ibm.addObserver(s);
        ibm.addObserver(b);

        ibm.setPrice(120.10);
        ibm.setPrice(100.00);
        ibm.setPrice(121.00);
        ibm.setPrice(120.50);
        ibm.setPrice(120.75);
        ibm.setSymbol("IBMTEST");
    }
}
