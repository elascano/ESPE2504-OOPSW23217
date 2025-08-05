package ec.edu.espe.strategy.view;

import ec.edu.espe.strategy.model.SortingContext;

/**
 *
 * @author Jahir Sivinta DCCO
 */
public class SortApp {

    public static void main(String args[]) {
        int data[] = {3, 6, 4, 6, 7, 8, 5, 6, 7, 5, 3, 3};

        System.out.print("Arreglo original: ");
        for (int num : data) {
            System.out.print(num + " ");
        }
        System.out.println();

        SortingContext sc = new SortingContext();
        int sortedList[] = sc.sort(data);
    }
}
