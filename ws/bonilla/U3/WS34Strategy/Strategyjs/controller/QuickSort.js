const SortingStrategy = require('./SortingStrategy');

class QuickSort extends SortingStrategy {
    sort(data) {
        console.log("Usando Quick Sort...");
        const sortedData = [...data];
        this.quickSort(sortedData, 0, sortedData.length - 1);
        this.mostrarArreglo(sortedData);
        return sortedData;
    }

    quickSort(arr, low, high) {
        if (low < high) {
            const pi = this.particion(arr, low, high);
            this.quickSort(arr, low, pi - 1);
            this.quickSort(arr, pi + 1, high);
        }
    }

    particion(arr, low, high) {
        const pivot = arr[high];
        let i = low - 1;

        for (let j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                [arr[i], arr[j]] = [arr[j], arr[i]];
            }
        }

        [arr[i + 1], arr[high]] = [arr[high], arr[i + 1]];
        return i + 1;
    }

    mostrarArreglo(data) {
        process.stdout.write("Resultado: ");
        data.forEach(num => process.stdout.write(num + " "));
        console.log();
    }
}

module.exports = QuickSort;
