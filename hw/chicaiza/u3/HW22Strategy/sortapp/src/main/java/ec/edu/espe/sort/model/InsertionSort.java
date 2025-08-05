/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.sort.model;

/**
 *
 * @author Chicaiza Michael
 */
public class InsertionSort implements SortingStrategy{
    public int[] sort(int data[]){
        int[] result = data.clone();

        for (int i = 1; i < result.length; i++) {
            int key = result[i];
            int j = i - 1;

            while (j >= 0 && result[j] > key) {
                result[j + 1] = result[j];
                j--;
            }
            result[j + 1] = key;
            }

        System.out.println("Using InsertionSort");
        return result;
        
    }
    
}
