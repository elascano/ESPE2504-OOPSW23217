/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.hwstrategy;

/**
 *
 * @author Kevin Vaca Edison's OOP ESPE
 */
public class SortingContext {
       private SortingStrategy strategy;
    
    public int[] sort(int[] data) {
        int size = data.length;
        setSortStrategy(size);
        return strategy.sort(data);
    }
    
    private void setSortStrategy(int size) {
        if (size < 10) {
            this.strategy = new BubbleSort();
        } else if (size < 100) {
            this.strategy = new InsertionSort();
        } else {
            this.strategy = new QuickSort();
        }
        System.out.println("Strategy set to: " + strategy.getClass().getSimpleName());
    }
    
    // Optional: Allow manual strategy setting
    public void setStrategy(SortingStrategy strategy) {
        this.strategy = strategy;
    }
}
