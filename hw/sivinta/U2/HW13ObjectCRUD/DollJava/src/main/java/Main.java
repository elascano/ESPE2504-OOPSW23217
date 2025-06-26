import service.MunecaService;
import model.Muneca;
import service.MunecaService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MunecaService servicio = new MunecaService();

        System.out.println("== REGISTRO DE MUÑECA ==");

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine().trim();

        System.out.print("Precio: ");
        double precio = Double.parseDouble(scanner.nextLine().trim());

        System.out.print("Calidad (Alta / Media / Baja): ");
        String calidad = scanner.nextLine().trim();

        Muneca muneca = new Muneca(nombre, precio, calidad);
        servicio.calcularCostos(muneca);
        servicio.guardarEnMongo(muneca);

        System.out.println("\n✅ Muñeca registrada con éxito.");
        System.out.println("Costo calidad: $" + muneca.getCostoCalidad());
        System.out.println("Costo envío: $" + muneca.getCostoEnvio());
        System.out.println("Costo total: $" + muneca.getCostoTotal());
    }
}

