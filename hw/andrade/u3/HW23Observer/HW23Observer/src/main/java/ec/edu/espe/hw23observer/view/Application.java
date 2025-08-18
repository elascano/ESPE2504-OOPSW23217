/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espe.hw23observer.view;

import ec.edu.espe.hw23observer.model.IBM;
import ec.edu.espe.hw23observer.model.Investor;

/**
 *
 * @author Julio Andrade
 */
public class Application {

    public static void main(String[] args) {
        Investor s = new Investor("Sorros");
        Investor b = new Investor("Berkshire");

        IBM ibm = new IBM("IBM", 140.00);
        ibm.addObserver(s);
        ibm.addObserver(b);

        ibm.setPrice(140.10);
        ibm.setPrice(141.00);
        ibm.setPrice(140.70);
        ibm.setPrice(140.65);
        ibm.setSymbol("IBMTEST");
    }
}
