const SortingStrategy = require('./SortingStrategy');

class BubbleSort extends SortingStrategy {
    sort(data) {
        console.log("Usando Bubble Sort...");
        const sortedData = [...data];
        const n = sortedData.length;

        for (let i = 0; i < n - 1; i++) {
            for (let j = 0; j < n - i - 1; j++) {
                if (sortedData[j] > sortedData[j + 1]) {
                    const temp = sortedData[j];
                    sortedData[j] = sortedData[j + 1];
                    sortedData[j + 1] = temp;
                }
            }
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

module.exports = BubbleSort;
