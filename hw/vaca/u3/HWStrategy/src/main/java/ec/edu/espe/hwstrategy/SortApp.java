/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.hwstrategy;

/**
 *
 * @author Kevin Vaca Edison's OOP ESPE
 */
public class SortApp {
        public static void main(String args[]) {
        int data[] = {3,6,4,6,7,8,5,6,7,5,3,3};
        
        SortingContext sc = new SortingContext();
        
        System.out.println("Original array:");
        printArray(data);
        
        int[] sortedList = sc.sort(data);
        
        System.out.println("\nSorted array:");
        printArray(sortedList);
        
        // Demonstrate manual strategy selection
        System.out.println("\nManual strategy selection:");
        sc.setStrategy(new QuickSort());
        int[] quickSorted = sc.sort(data.clone());
        printArray(quickSorted);
        
        sc.setStrategy(new BubbleSort());
        int[] bubbleSorted = sc.sort(data.clone());
        printArray(bubbleSorted);
    }
    
    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
