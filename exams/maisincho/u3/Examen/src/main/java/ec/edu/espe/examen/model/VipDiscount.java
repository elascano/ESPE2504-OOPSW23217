/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.examen.model;

public class VipDiscount implements Discount {
	@Override
	public double apply(double price) {
		return price * 0.8;
	}
}
