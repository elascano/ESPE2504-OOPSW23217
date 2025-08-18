/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.saleapp.model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author jorge
 */
abstract class Stock {
    protected String symbol; 
    protected double price; 
    private ArrayList investors = new ArrayList();

    public String getSymbol() {
        return symbol;
    }

    public Stock() { }
    public void addObserver( IInvestor iinvestor ) {

        investors.add( iinvestor );
    } 
    
    public void deleteObserver( IInvestor iinvestor ) { 

        investors.remove( iinvestor );
    } 
    public void notifyObservers(Object args) {
        Iterator i = investors.iterator();
        
        while( i.hasNext() ) {
            IInvestor investor = (IInvestor)i.next();
            investor.update(this,args );

        }
    } 


}
