package ec.edu.espe.template.strategy.controller;

import ec.edu.espe.template.strategy.model.SortingStrategy;
import ec.edu.espe.template.strategy.model.BubbleSort;
import ec.edu.espe.template.strategy.model.InsertionSort;
import ec.edu.espe.template.strategy.model.QuickSort;

/**
 *
 * @author Gerald Astudillo
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
