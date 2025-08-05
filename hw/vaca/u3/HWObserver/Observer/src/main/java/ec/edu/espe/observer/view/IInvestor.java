/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.espe.observer.view;

import ec.edu.espe.observer.model.Stock;

/**
 *
 * @author LABS-ESPE
 */
public interface IInvestor {
    void update(Stock stock, Object arg);
}
