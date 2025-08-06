/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espe.saleapp.view;

import ec.edu.espe.saleapp.model.IBM;
import ec.edu.espe.saleapp.model.Investor;

/**
 *
 * @author Chicaiza Michael
 */
public class Application {

    public static void main(String[] args) {
        Investor s = new Investor("Sorros");
        Investor b = new Investor("Berkshire");
        
        IBM ibm = new IBM("IBM",120.00);
        ibm.addObserver(s);
        ibm.addObserver(b);
        
        ibm.setPrice(120.10);
        ibm.setPrice(121.00);
        ibm.setPrice(120.50);
        ibm.setPrice(120.75);
        ibm.setSymbol("IBMTEST");
    }
}
