/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.examen.model;

public class LargePackage extends ShipmentPackage {
	public LargePackage(double weightKg, double declaredValue, String description, String trackingCode, boolean fragile, Discount discountStrategy) {
		super(weightKg, declaredValue, description, trackingCode, fragile, discountStrategy);
	}

	@Override
	protected void packageContent() {
		System.out.println("Empaquetando contenido grande");
	}

	@Override
	protected void calculatePrice() {
		originalPrice = 20.0 + weightKg * 1.0;
	}
}
