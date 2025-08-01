package ec.edu.espe.hw16mazegenerator.view;

import ec.edu.espe.hw16mazegenerator.model.Maze;

/**
 *
 * @author Mateo Unda
 */
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el numero de filas del laberinto: ");
        int rows = scanner.nextInt();

        System.out.print("Ingrese el numero de columnas del laberinto: ");
        int cols = scanner.nextInt();

        if (rows < 1 || cols < 1) {
            System.out.println("Dimensiones invalidas. Deben ser mayores a 0.");
            return;
        }

        Maze maze = new Maze(rows, cols);
        maze.display();
    }
}
