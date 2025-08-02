package ec.edu.espe.strategy.model;

import ec.edu.espe.strategy.controller.BubbleSort;
import ec.edu.espe.strategy.controller.InsertionSort;
import ec.edu.espe.strategy.controller.QuickSort;
import ec.edu.espe.strategy.controller.SortingStrategy;

/**
 *
 * @author Bonilla David SoftCrafters
 */
public class SortingContext {

    private SortingStrategy ss;

    public int[] sort(int data[]) {
        int size = data.length;
        ss = setSortStrategy(size);
        return ss.sort(data);
    }

    public SortingStrategy setSortStrategy(int n) {
        if (n > 0 && n < 30) {
            ss = new BubbleSort();
        }

        if (n >= 30 && n < 100) {
            ss = new InsertionSort();
        }

        if (n >= 100) {
            ss = new QuickSort();
        }

        return ss;
    }
}
