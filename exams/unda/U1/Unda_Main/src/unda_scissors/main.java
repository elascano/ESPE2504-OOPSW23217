package unda_scissors;

public class Unda_Main {
    public static void main(String[] args) {
        Unda_ScissorsManager manager = new Unda_ScissorsManager();

        manager.addScissors(new Unda_Scissors(1, "Fiskars", 8, false));
        manager.addScissors(new Unda_Scissors(2, "Maped", 6, true));
        manager.addScissors(new Unda_Scissors(3, "Stanley", 7, false));

        try {
            manager.saveToCSV();    // Guardar en CSV
            manager.loadFromCSV();  // Leer desde CSV
            manager.showAll();      // Mostrar en consola
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
