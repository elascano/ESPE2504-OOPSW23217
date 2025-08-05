/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espe.sort.view;

import ec.edu.espe.sort.model.SortingContext;
import java.util.Arrays;

/**
 *
 * @author Chicaiza Michael
 */
public class SortApp {

    public static void main(String[] args) {
        int data[] = {3,6,4,6,7,8,5,6,7,5,3,3};
        SortingContext sc = new SortingContext();
        int sortedList[] = sc.sort(data);
        
        System.out.println("Sorted array: " + Arrays.toString(sortedList));
    }
}
