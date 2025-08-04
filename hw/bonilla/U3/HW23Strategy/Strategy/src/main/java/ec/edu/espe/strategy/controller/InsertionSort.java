package ec.edu.espe.strategy.controller;

/**
 *
 * @author Bonilla David SoftCrafters
 */
public class InsertionSort implements SortingStrategy {

    @Override
    public int[] sort(int data[]) {
        System.out.println("Usando Insertion Sort...");
        int[] sortedData = data.clone();

        for (int i = 1; i < sortedData.length; i++) {
            int key = sortedData[i];
            int j = i - 1;

            while (j >= 0 && sortedData[j] > key) {
                sortedData[j + 1] = sortedData[j];
                j = j - 1;
            }
            sortedData[j + 1] = key;
        }

        mostrarArreglo(sortedData);
        return sortedData;
    }

    private void mostrarArreglo(int[] data) {
        System.out.print("Resultado: ");
        for (int num : data) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}