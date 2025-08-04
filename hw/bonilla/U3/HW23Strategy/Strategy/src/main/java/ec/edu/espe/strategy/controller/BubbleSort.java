package ec.edu.espe.strategy.controller;

/**
 *
 * @author Bonilla David SoftCrafters
 */
public class BubbleSort implements SortingStrategy {

    @Override
    public int[] sort(int data[]) {
        System.out.println("Usando Bubble Sort...");
        int n = data.length;
        int[] sortedData = data.clone();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (sortedData[j] > sortedData[j + 1]) {
                    int temp = sortedData[j];
                    sortedData[j] = sortedData[j + 1];
                    sortedData[j + 1] = temp;
                }
            }
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
