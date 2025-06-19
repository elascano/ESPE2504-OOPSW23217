package model;

public class Muneca {
    private String nombre;
    private double precio;
    private String calidad;
    private double costoCalidad;
    private double costoEnvio;
    private double costoTotal;

    public Muneca(String nombre, double precio, String calidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.calidad = calidad;
    }

    // Getters
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public String getCalidad() { return calidad; }
    public double getCostoCalidad() { return costoCalidad; }
    public double getCostoEnvio() { return costoEnvio; }
    public double getCostoTotal() { return costoTotal; }

    // Setters para cálculos
    public void setCostoCalidad(double costoCalidad) { this.costoCalidad = costoCalidad; }
    public void setCostoEnvio(double costoEnvio) { this.costoEnvio = costoEnvio; }
    public void setCostoTotal(double costoTotal) { this.costoTotal = costoTotal; }
}
