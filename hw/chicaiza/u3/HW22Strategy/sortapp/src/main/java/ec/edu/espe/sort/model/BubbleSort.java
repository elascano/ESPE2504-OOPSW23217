/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.sort.model;

/**
 *
 * @author Chicaza Michael
 */
public class BubbleSort implements SortingStrategy{
    public int[] sort(int data[]){
        int n = data.length;
        int[] result = data.clone();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (result[j] > result[j + 1]) {
                    int temp = result[j];
                    result[j] = result[j + 1];
                    result[j + 1] = temp;
                }
            }
        }

        System.out.println("Using BubbleSort");
        return result;
        
    }
    
    
}
