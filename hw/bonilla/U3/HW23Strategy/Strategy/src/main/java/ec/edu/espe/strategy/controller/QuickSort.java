package ec.edu.espe.strategy.controller;

/**
 *
 * @author Bonilla David SoftCrafters
 */
public class QuickSort implements SortingStrategy {

    @Override
    public int[] sort(int data[]) {
        System.out.println("Usando Quick Sort...");
        int[] sortedData = data.clone();
        quickSort(sortedData, 0, sortedData.length - 1);
        mostrarArreglo(sortedData);
        return sortedData;
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = particion(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private int particion(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    private void mostrarArreglo(int[] data) {
        System.out.print("Resultado: ");
        for (int num : data) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
