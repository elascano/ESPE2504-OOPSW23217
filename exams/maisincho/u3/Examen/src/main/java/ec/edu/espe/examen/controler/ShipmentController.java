package ec.edu.espe.examen.controler;

import ec.edu.espe.examen.model.*;
import ec.edu.espe.examen.utils.ShipmentDao;

public class ShipmentController {
	public static void processShipment(Client client, String type, double weight, double declaredValue, String description, String trackingCode, boolean fragile) {
		ShipmentPackage pkg;
		Discount discount = client.isVip() ? new VipDiscount() : new NoDiscount();

		switch (type) {
			case "Pequeño":
				pkg = new SmallPackage(weight, declaredValue, description, trackingCode, fragile, discount);
				break;
			case "Mediano":
				pkg = new MediumPackage(weight, declaredValue, description, trackingCode, fragile, discount);
				break;
			case "Grande":
				pkg = new LargePackage(weight, declaredValue, description, trackingCode, fragile, discount);
				break;
			default:
				throw new IllegalArgumentException("Tipo de paquete no válido");
		}

		pkg.processShipment();
		ShipmentDao.saveShipment(client, pkg);
	}
}
