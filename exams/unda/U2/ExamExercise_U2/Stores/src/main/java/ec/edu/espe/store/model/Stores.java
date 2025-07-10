/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espe.store.model;

/**
 *
 * @author LABS-ESPE
 */
public class Stores {
    private int id;
    private String name;
    private double area;
    private double sales;

    public Stores(int id, String name, double area, double sales) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.sales = sales;
    }

    public double calculateProfit() {
        // Supongamos que la utilidad es el 30% de las ventas menos el 5% del área
        return (sales * 0.3) - (area * 0.05);
    }

    // Getters y setters
    public int getId() { return id; }
    public String getName() { return name; }
    public double getArea() { return area; }
    public double getSales() { return sales; }
}

