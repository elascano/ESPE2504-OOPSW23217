/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espe.hw22strategy.view;

import ec.edu.espe.hw22strategy.controller.SortingContext;
import java.util.Scanner;

/**
 *
 * @author Micaela Jacome DESKTOP-46VMNHU ESPE
 */
public class SortApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SortingContext sortingContext = new SortingContext();
        
        System.out.print("Ingrese el numero de elementos: ");
        int n = scanner.nextInt();
        
        int[] data = new int[n];
        System.out.println("Ingrese " + n + " numeros:");
        
        for (int i = 0; i < n; i++) {
            data[i] = scanner.nextInt();
        }
        
        System.out.println("Array original:");
        printArray(data);
        
        int[] sortedData = sortingContext.sort(data.clone());
        
        System.out.println("Array ordenado:");
        printArray(sortedData);
        
        scanner.close();
    }
    
    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
