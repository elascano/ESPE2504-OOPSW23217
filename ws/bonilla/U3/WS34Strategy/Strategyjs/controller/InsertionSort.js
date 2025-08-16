const SortingStrategy = require('./SortingStrategy');

class InsertionSort extends SortingStrategy {
    sort(data) {
        console.log("Usando Insertion Sort...");
        const sortedData = [...data];

        for (let i = 1; i < sortedData.length; i++) {
            const key = sortedData[i];
            let j = i - 1;

            while (j >= 0 && sortedData[j] > key) {
                sortedData[j + 1] = sortedData[j];
                j--;
            }
            sortedData[j + 1] = key;
        }

        this.mostrarArreglo(sortedData);
        return sortedData;
    }

    mostrarArreglo(data) {
        process.stdout.write("Resultado: ");
        data.forEach(num => process.stdout.write(num + " "));
        console.log();
    }
}

module.exports = InsertionSort;
