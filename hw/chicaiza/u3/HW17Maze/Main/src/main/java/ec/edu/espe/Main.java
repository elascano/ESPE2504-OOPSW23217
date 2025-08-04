/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espe;

import ec.edu.espe.controller.MazeController;
import ec.edu.espe.view.MazeConsoleView;
import java.util.Scanner;

/**
 *
 * @author Michael Chicaiza SOFTCRAF DCCO ESPE
 */
public class Main {
public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el ancho (N): ");
        int width = sc.nextInt();
        System.out.print("Ingrese la altura (M): ");
        int height = sc.nextInt();

        MazeController controller = new MazeController(width, height, new MazeConsoleView());
        controller.displayMaze();
    }
}
